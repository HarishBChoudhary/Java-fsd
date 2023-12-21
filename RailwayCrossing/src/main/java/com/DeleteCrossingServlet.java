package com;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCrossingServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieve the crossing ID from the request
				int crossingId = Integer.parseInt(request.getParameter("id"));

				// Perform the delete operation (implement your logic)
				RailwayCrossingDAOImpl crossingDAO = new RailwayCrossingDAOImpl();
				crossingDAO.deleteCrossing(crossingId);

				// Redirect to the admin homepage after the deletion
				response.sendRedirect("adminHome.jsp");
	}

}
