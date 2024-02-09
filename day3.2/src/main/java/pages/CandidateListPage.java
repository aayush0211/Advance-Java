package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidatesDaoImpl;
import pojos.Candidate;
import pojos.User;


@WebServlet("/candidate_list")
public class CandidateListPage extends HttpServlet{
	private CandidatesDaoImpl dao;
//	private UserDaoImpl dao1;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			dao.cleanup();
		}catch(Exception e) {
			throw new RuntimeException("err in destroy"+getClass(),e);
		}
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		try {
		 dao = new CandidatesDaoImpl();
//		 dao1 = new UserDaoImpl(); 
		}catch(Exception e) {
			throw new ServletException("err in init"+getClass(),e);
		}
	}

	//doGet
	@Override
	public void doGet(HttpServletRequest rq,HttpServletResponse rs) throws ServletException,IOException
	{
		System.out.println("in candidate list page ");
		
		try(PrintWriter pw = rs.getWriter()){
			List<Candidate> lists = dao.getAllCandidates();
			HttpSession hs = rq.getSession();
			hs.setAttribute("cndList", lists);
			User user = (User)hs.getAttribute("user");
			pw.print("<table><form action = 'logout' method = 'post'>"
					+ "<tr><h4>Hello"+user.getFirstName()+"</h4></tr>"
							+ "<tr><h4>Vote to</h4></tr>");
			lists.forEach(p-> pw.print( "<tr><h4><input type = 'radio' name = 'cnd' required value="+p.getId()+"><label for='cnd'>"+p.getName()+" "+p.getParty()+"</label></input>"
					+ "</h4></tr>"));
			pw.print("<tr><h4><input type='submit' value = 'vote' /></h4></tr></form></table>");
			
		} catch (SQLException e) {
			throw new ServletException();
		}
		//1. set resp cont type
		
	}

}
