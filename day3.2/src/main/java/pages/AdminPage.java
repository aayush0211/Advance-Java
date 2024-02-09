package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
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


@WebServlet("/admin_page")
public class AdminPage extends HttpServlet{
	//doGet
	@Override
	public void doGet(HttpServletRequest rq,HttpServletResponse rs) throws ServletException,IOException
	{
		System.out.println("in admin page ");
		//1. set resp cont type
		rs.setContentType("text/html");
		//2. get PW : to send resp from servlet ---> web clnt
		
		try(PrintWriter pw=rs.getWriter()) {
			HttpSession hs = rq.getSession();
			CandidatesDaoImpl cndDao = (CandidatesDaoImpl)hs.getAttribute("cndDao");
			List<Candidate>list = cndDao.getTwoCandidatesMaxVotes(2);
			User user = (User)hs.getAttribute("user");
			//generate dyn cont (add dyn contents to buffer of PW
			pw.print("<h1>Welcome Admin "+user.getFirstName()+"!</h1>");
			pw.print("<h2>Candidates who get Maximum votes</h2>");
			list.forEach(p->pw.print("<h4>"+p.toString()+"</h4>"));
			
		}catch(Exception e) {
			throw new ServletException("err in doGet of "+getClass(), e);
		}
	}

}
