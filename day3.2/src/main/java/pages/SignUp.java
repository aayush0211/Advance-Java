package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import pojos.User;

/**
 * Servlet implementation class SignUp
 */
@WebServlet(urlPatterns = "/signup", loadOnStartup = 3)
public class SignUp extends HttpServlet {
	private UserDaoImpl userDao;
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("get init of " + getClass());
		try {
			userDao = new UserDaoImpl();
		} catch (Exception e) {
			throw new ServletException("err in init of " + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	@Override
	public void destroy() {
		try {
			userDao.cleanUp();
		} catch (Exception e) {
			throw new RuntimeException("err in destroy " + getClass(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			String firstName = request.getParameter("fname");
			String lastName = request.getParameter("lname");
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			LocalDate dob = LocalDate.parse(request.getParameter("dob"));
			if (Period.between(dob, LocalDate.now()).getYears() >= 21) {
				Date date = Date.valueOf(dob);
				String msg = userDao.registerNewVoter(new User(firstName, lastName, email, password, date));
				pw.print("<h4>"+msg+"Successfull"+"</h4>");
			} else {
				pw.print("<h3> Invalid age must be 21 or above<a href='register.html'> Retry </a> </h3>");
			}

		}catch(Exception e) {
			throw new ServletException("err in dopost of "+getClass(), e);
		}
	}

}
