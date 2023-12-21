package com;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/addCrossing")
public class AddCrossingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Retrieve the data from the form
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String landmark = request.getParameter("landmark");
		String trainSchedules = request.getParameter("schedule");
		String personInCharge = request.getParameter("person");
		String status = request.getParameter("status");

		// Create a new RailwayCrossing object with the form data
		RailwayCrossing1 crossing = new RailwayCrossing1();
		crossing.setName(name);
		crossing.setAddress(address);
		crossing.setLandmark(landmark);
		crossing.setSchedule(trainSchedules);
		crossing.setPerson(personInCharge);
		crossing.setStatus(status);

		// Save the new crossing to the database
		RailwayCrossingDAOImpl crossingDAO = new RailwayCrossingDAOImpl();
		crossingDAO.addCrossing(crossing);

		// Redirect to the admin homepage after adding the crossing
				response.sendRedirect("adminHome.jsp");
	}

}
