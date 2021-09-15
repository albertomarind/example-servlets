package com.sistema.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sistema.models.Role;
import com.sistema.models.User;
import com.sistema.services.RoleService;
import com.sistema.services.UserService;
import com.sistema.services.impl.RoleServiceImpl;
import com.sistema.services.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value = "/list-users.do")
public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> users = userService.findAllUsersWithRoles();
		request.setAttribute("users", users);
		request.getRequestDispatcher("/WEB-INF/views/list-users.jsp").forward(request, response);
	}

}
