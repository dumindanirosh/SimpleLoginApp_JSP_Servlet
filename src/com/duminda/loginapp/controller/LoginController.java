package com.duminda.loginapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Retrieve username and password Parameters
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		boolean validated = true;
		if (username == null || username.equals("")) {
			validated = false;
			request.setAttribute("errorMessage", "Please Enter User Name");

		} else if (password == null || password.equals("")) {
			validated = false;
			request.setAttribute("errorMessage", "Please  Enter Password ");

		}

		// Declare RequestDispatcher Object
		RequestDispatcher rd = null;

		if (validated) {

			// Assume correct user name is admin password is 123
			if (username.equals("admin") && password.equals("123")) {
				//
				rd = request.getRequestDispatcher("member.jsp");

				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(600);

				session.setAttribute("username", username);

			} else {
				rd = request.getRequestDispatcher("index.jsp");

				// set Error Message
				request.setAttribute("errorMessage",
						"Invalid User Name or Password");

			}
		} else {
			rd = request.getRequestDispatcher("index.jsp");

		}
		// Forward to specific jsp
		rd.forward(request, response);
	}

}
