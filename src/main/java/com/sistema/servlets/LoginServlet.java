package com.sistema.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sistema.models.User;
import com.sistema.services.UserService;
import com.sistema.services.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value = "/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService usuarioService = new UserServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("user") == null) {
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		} else {
			response.sendRedirect("/welcome.do");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = usuarioService.getUserAndRoleByUsernameAndPassword(username, password);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("/welcome.do");
		} else {
			request.setAttribute("errorMessage", "username or password incorrect");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}

	}

}
