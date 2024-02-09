package pages;

import static dbutils.DbUtil.closeConnection;
import static dbutils.DbUtil.openConnection;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDaoImpl;
import pojos.Course;

/**
 * Servlet implementation class StudentRegistrations
 */
@WebServlet("/StudentRegistrations")
public class StudentRegistrations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegistrations() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			pw.print("<h2> Student Registration form </h2>");
			pw.print("<form action=\"FormProcessing\" method=\"get\">");
			pw.print("<h4> chooes your courses :</h4>");
			
			for(Course c :Course.values())
			{
				pw.print("<h5> "+c.name()+"</h4>");
				pw.print("<input type=\"checkbox\" name=\"courses\" value=\""+c.name()+"\">");
			}
			pw.print("<h4> Enter your First_name :</h4>");
			pw.print("<input type=\"test\" name=\"fn\" >");
			pw.print("<h4> Enter your Last_name :</h4>");
			pw.print("<input type=\"test\" name=\"ln\" >");
			pw.print("<h4> Enter your Score :</h4>");
			pw.print("<input type=\"number\" name=\"marks\" >");
			pw.print("<input type=\"submit\" value=\"Register\" >");
			pw.print("</form>");
			
		}
	}

}
