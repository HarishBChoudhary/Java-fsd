package com;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateCrossing")
public class UpdateCrossingServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			// Retrieve the crossing ID from the hidden field
			String idParam = request.getParameter("crossingId");

			if (idParam != null && !idParam.isEmpty()) {
				int crossingId = Integer.parseInt(idParam);

				// Retrieve the updated details for the crossing
				String name = request.getParameter("name");
				String address = request.getParameter("address");
				String landmark = request.getParameter("landmark");
				String trainSchedules = request.getParameter("trainSchedules");
				String personInCharge = request.getParameter("personInCharge");
				String status = request.getParameter("status");

				// Create a new RailwayCrossing object with the updated details
				RailwayCrossing1 updatedCrossing = new RailwayCrossing1();
				updatedCrossing.setId(crossingId);
				updatedCrossing.setName(name);
				updatedCrossing.setAddress(address);
				updatedCrossing.setLandmark(landmark);
				updatedCrossing.setSchedule(trainSchedules);
				updatedCrossing.setPerson(personInCharge);
				updatedCrossing.setStatus(status);

				// Perform the update operation
				RailwayCrossingDAOImpl crossingDAO = new RailwayCrossingDAOImpl();
				crossingDAO.updateCrossing(updatedCrossing);

				// Redirect to the admin homepage after the update
				response.sendRedirect("adminHome.jsp");
			} else {
				// Handle case where idParam is empty or null
				throw new ServletException("Crossing ID is missing.");
			}

		} catch (NumberFormatException e) {
			// Handle case where idParam is not a valid integer
			throw new ServletException("Invalid Crossing ID format.", e);
		} catch (Exception e) {
			// Handle other exceptions
			throw new ServletException("An error occurred during the crossing update.", e);
		}
	
	}

}
