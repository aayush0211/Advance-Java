package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlayerDaoImpl;
import dao.TeamDaoImpl;
import pojos.Player;
import pojos.Team;

/**
 * Servlet implementation class authenticatePlayer
 */
@WebServlet("/authenticatePlayer")
public class authenticatePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {

			HttpSession session = request.getSession();

			PlayerDaoImpl playerDao = (PlayerDaoImpl) session.getAttribute("player_dao");
			TeamDaoImpl teamDao = (TeamDaoImpl) session.getAttribute("team_dao");

			if (teamDao != null) {
				String abbr = request.getParameter("abbrevation");
				String fname = request.getParameter("fnm");
				String lname = request.getParameter("lnm");
				LocalDate dob = LocalDate.parse(request.getParameter("dob"));
				double avg = Double.parseDouble(request.getParameter("avg"));
				int wicketTaken = Integer.parseInt(request.getParameter("wickets"));
				int age = Period.between(dob, LocalDate.now()).getYears();

				Team selectTeam = teamDao.getTeamDetails(abbr);
				System.out.println(selectTeam);

				if (age < selectTeam.getMaxAge() && avg > selectTeam.getMinBattingAvg()
						&& wicketTaken > selectTeam.getMinWicketsTaken()) {
					Date validAge = Date.valueOf(dob);
					Player newPlayer = new Player(fname, lname, validAge, avg, wicketTaken);
					playerDao.addPlayerToTeam(newPlayer, selectTeam.getTeamId());
					pw.print("<h4>Player " + fname + " " + lname + " is succesfully added </h4>");

				} else {
					pw.print("<h4> Your wickets is less so you cant be qualified for our team </h4>");
					pw.print("<h4>Your age is below our needs Sorry!!!</h4>");
					pw.print("<h4>Your avg is quite less , we cant select you for our team</h4>");
					pw.print("<h4> <a href = 'index.html'> Back to Homepage </a></h4>");
				}

			} else {
				pw.print("<h2> Invalid Session tracking <h2>");
			}

			session.invalidate();

		} catch (Exception e) {
			throw new ServletException("err in do-post" + getClass(), e);
		}

	}

}
