package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidatesDaoImpl;
import dao.UserDaoImpl;
import pojos.User;
import static utils.DBUtils.*;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/authenticate", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private UserDaoImpl userDao;
    private CandidatesDaoImpl cndDao;
	/**
	 * @see Servlet#init()
	 */
	@Override
	public void init() throws ServletException {
		System.out.println("in init of " + getClass());
		try { Connection cn = openConnection();
			// create user dao instance
			userDao = new UserDaoImpl();
			 cndDao = new CandidatesDaoImpl();
		} catch (Exception e) {
			// centralized err handling
			throw new ServletException("err in init of " + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	@Override
	public void destroy() {
		System.out.println("in destroy of " + getClass());
		try {
			userDao.cleanUp();
			cndDao.cleanup();
		} catch (Exception e) {
			// inform WC about the err : OPTIONAL !
			throw new RuntimeException("err in destroy of " + getClass(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. set resp cont type
		response.setContentType("text/html");
		HttpSession hs = request.getSession();
		hs.setAttribute("userDao", userDao);
		hs.setAttribute("cndDao",cndDao);
		
		// 2. get PW to send buffered text resp to the clnt
		try (PrintWriter pw = response.getWriter()) {
			// 3. Read req params
			 //create session
			String email = request.getParameter("em");
			String pwd = request.getParameter("pass");
			// 4. invoke user dao's method for auth
			User user = userDao.authenticateUser(email, pwd);
			if (user == null) // => invalid login
				pw.print("<h4> Invalid Login Please <a href='login.html'>Retry</a></h4>");
			else // login successful
			{
				hs.setAttribute("user",user );//add attribute user pojo object in map(key,obj)
				//role based authorization
				if(user.getRole().equals("admin"))
					response.sendRedirect("admin_page");
				else { //voter role
					if(user.isVotingStatus()) //alrdy voted voter
						response.sendRedirect("logout");
					else //not yet voted
						response.sendRedirect("candidate_list");						
				}
			}
		} catch (Exception e) {
			throw new ServletException("err in do-post" + getClass(), e);
		}
	}

}
