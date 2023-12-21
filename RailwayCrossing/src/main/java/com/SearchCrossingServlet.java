package com;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SearchCrossingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieve the search ID from the request
		int searchId = Integer.parseInt(request.getParameter("searchId"));

		// Implement your logic to search for the crossing by ID and retrieve its
		// details from the database
		RailwayCrossingDAOImpl crossingDAO = new RailwayCrossingDAOImpl();
		RailwayCrossing1 crossing = crossingDAO.getCrossingById(searchId);

		// Set the search result in the request attribute
		request.setAttribute("crossing", crossing);

		// Redirect to the admin homepage with the search results
		request.getRequestDispatcher("adminHome.jsp").forward(request, response);
	
	}

}
