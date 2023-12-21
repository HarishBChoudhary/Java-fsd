package com;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminHomePageServlet extends HttpServlet {

	private RailwayCrossingDAOImpl crossingDAO;

	public void init() {
		crossingDAO = new RailwayCrossingDAOImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Fetch all railway crossing details from the database
		List<RailwayCrossing1> crossings = crossingDAO.getAllCrossings();

		// Pass the crossing details to the JSP page
		request.setAttribute("crossings", crossings);
		request.getRequestDispatcher("adminHome.jsp").forward(request, response);
	}

}
