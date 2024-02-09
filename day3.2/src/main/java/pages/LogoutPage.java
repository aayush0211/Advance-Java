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
import dao.UserDao;
import dao.UserDaoImpl;
import pojos.Candidate;
import pojos.User;

@WebServlet(value="/logout",loadOnStartup=2)
public class LogoutPage extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		rs.setContentType("text/html");
		int cndId = Integer.parseInt(rq.getParameter("cnd"));
		System.out.println("candidate "+cndId);
		HttpSession hs = rq.getSession();
		try (PrintWriter pw = rs.getWriter()) {
			User user = (User) hs.getAttribute("user");
			
			UserDaoImpl userDao = (UserDaoImpl) hs.getAttribute("userDao");
			
				userDao.changeVotingStatus(user);
				Candidate candidate = userDao.getCandidate(cndId);
				candidate.setVotes(candidate.getVotes());
				userDao.increaseVotingStatus(candidate);
				pw.print("<h4>Hello " + user.getFirstName() + " " + user.getLastName() + "</h4>"
						+ "<h4>you have vote to " + candidate.getName() + "  party = " + candidate.getParty() + "</h4>"
						+ "<h4>Thank you for visiting!!!!</h4>");
				pw.flush();
			
			hs.invalidate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		HttpSession hs = req.getSession();
		User user = (User)hs.getAttribute("user");
		try(PrintWriter pw = resp.getWriter()){
		pw.print("<h4>Hello " + user.getFirstName() + " " + user.getLastName() + "</h4>"
				+ "<h4>you have already voted!!!</h4>" + "<h4>Thank you for visiting!!!!</h4>");

		}catch (Exception e) {
			// TODO: handle exception
			throw new ServletException("err in doGet of "+getClass(),e);
		}
	
		}
	
}
