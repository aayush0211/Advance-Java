package pages;

import static utils.DBUtils.closeConnection;
import static utils.DBUtils.openConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlayerDaoImpl;
import dao.TeamDaoImpl;

/**
 * Servlet implementation class addPlayer
 */
@WebServlet("/addPlayer")
public class addPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
		private TeamDaoImpl tm;
		private PlayerDaoImpl pl;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override	
	public void init() throws ServletException {
		try {
			openConnection();
			tm = new TeamDaoImpl();
			pl = new PlayerDaoImpl();
			
		} catch (SQLException e) {
			throw new ServletException("err in  init"+getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			tm.cleanUp();
			pl.cleanUp();
			closeConnection();
		} catch (Exception e) {
			System.out.println("err in destroy...");
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter()){
			HttpSession session = request.getSession();
			
			session.setAttribute("player_dao", pl);
			session.setAttribute("team_dao", tm);
			
			List<String> teamsAbbreviations = tm.getTeamsAbbreviations();
			
			pw.print("<form method = 'post' action='authenticatePlayer'>");
			pw.print("<h5> Choose a team: <select name = 'abbrevation'> ");
			for(String s: teamsAbbreviations)
				  pw.print("<h5> <option value = '"+s+"'</option>"+s+"</h5>");
				pw.print("</h5></select>");
				pw.print("<h5>Player First Name <input type='text' name ='fnm'/></h5>");
				pw.print("<h5>Player Last Name <input type='text' name ='lnm'/></h5>");
				pw.print("<h5>DOB <input type = 'date' name= 'dob' /></h5>");
				pw.print("<h5>Batting Avg <input type='number' name='avg' /></h5>");
				pw.print("<h5>Wickets Taken <input type='text' name='wickets'/></h5>");
				pw.print("<h5><input type='submit' value='Add New Player'/></h5>");
				pw.print("</form>");
		
				
		}catch (Exception e) {
			throw new ServletException("err in do-get"+getClass(),e);
			
		}
	}

}
