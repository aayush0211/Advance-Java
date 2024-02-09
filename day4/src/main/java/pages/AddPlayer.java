package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlayerDaoImpl;

import dao.TeamDaoImpl;
import pojos.Team;

import static utils.DBUtils.*;
/**
 * Servlet implementation class AddPlayer
 */
@WebServlet(value= "/addPlayer",loadOnStartup=1)
public class AddPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlayerDaoImpl playerDao;
    private TeamDaoImpl teamDao;
	
	@Override
	public void init() throws ServletException {
		try {
			System.out.println("in init of"+getClass());
		openConnection();
		 playerDao = new PlayerDaoImpl();
		 teamDao = new TeamDaoImpl();
		}catch(Exception e) {
			throw new ServletException("err in init of "+getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
	try {
		teamDao.cleanUp();
		playerDao.cleanUp();
		closeConnection();
	}catch(Exception e) {
		throw new RuntimeException("err in destroy of "+getClass(), e);
	}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	                 response.setContentType("text/html");
	                 try(PrintWriter pw = response.getWriter()) {
	                 HttpSession hs = request.getSession();
	                 hs.setAttribute("teamDao", teamDao);
	                 hs.setAttribute("playerDao", playerDao);
	                 
	                 List<Team>list = teamDao.getAllTeam();
	                 pw.print("<table><form action='authenticatePlayer'><th colspan='2'><h3>Player Registration Form</h3></th>"
	                 		+ "<tr><h3></h3></tr>"
	                 		+ "<tr><h4><td>Choose a Team</td>"
	                 		+ "<td><select name='cr' id='cr' size='1' required> ");
	                 list.forEach(t->pw.print("<option value="+t.getTeamId()+"> "+t.getAbbrevation()+" </option>"));
	               pw.print("</select></td></h4></tr>"
	               		+ "<tr><td><h4>Name</h4></td>"
	               		+ "<td><input type='text' name='nm' placeholder='enter name' required/></td></tr>"
	               		+ "<tr><td><h4>DoB</h4></td>"
	               		+ "<td><input type='date' name='dob' required /></td></tr>"
	               		+ "<tr><td><h4>Batting Avg</h4></td>"
	               		+ "<td><input type='number' name='batting_avg' /></td></tr>"
	               		+ "<tr><td><h4>Wickets Taken</h4></td>"
	               		+ "<td><input type='number' name='wickets' /></td></tr>"
	               		+ "<tr><td colspan='2'><input type='submit' name='btn' value='register' />Add Player</td></tr>"
	               		+ "</form></table>");
	                
	                 }
	                 catch(Exception e) {
	                	 throw new ServletException("err in doGet of "+getClass(), e);
	                 }
	}

}
