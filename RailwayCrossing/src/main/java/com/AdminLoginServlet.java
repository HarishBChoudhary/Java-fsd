package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {
	
	private static final String ADMIN_ID = "harish.admin@gmail.com";
    private static final String ADMIN_PASSWORD = "admin";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		if(email!=null&&password!=null&&email.equals(ADMIN_ID)&&password.equals(ADMIN_PASSWORD)) {
			
			request.getRequestDispatcher("adminHome.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
		}
	}

}
