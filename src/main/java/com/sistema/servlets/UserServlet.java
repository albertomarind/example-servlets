package com.sistema.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sistema.services.UserService;
import com.sistema.services.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value = "/users.do")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService usuarioService = new UserServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rol = request.getParameter("rol");
//		if (usuarioService.isUserInDatabase(username, password) != null) {
//			response.sendRedirect("/welcome.do");
//		} else {
//			request.setAttribute("errorMessage", "username or password incorrect");
//			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
//		}

	}

}
