package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Retrieve the form data
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// check if the provided credentials are valid
		UserDAO userDAO = new UserDAO();
		User user = userDAO.getUserByEmail(email);
		
		if(user!=null&&user.getPassword().equals(password)) {
			//Authentication sucesssful
			//You can store user details in session for further use
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			
			//Redirect to a success page
			response.sendRedirect("userHome.jsp");
		}
		else {
			//Authentication failed
			response.sendRedirect("userRegister.jsp?error=1");
		}
	}

}
