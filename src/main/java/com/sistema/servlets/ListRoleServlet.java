package com.sistema.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sistema.models.Role;
import com.sistema.models.User;
import com.sistema.services.RoleService;
import com.sistema.services.impl.RoleServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value = "/list-roles.do")
public class ListRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RoleService roleService = new RoleServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListRoleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Role> roles = roleService.findAll();
		request.setAttribute("roles", roles);
		request.getRequestDispatcher("/WEB-INF/views/list-roles.jsp").forward(request, response);
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
