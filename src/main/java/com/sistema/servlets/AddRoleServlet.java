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
import com.sistema.services.UserService;
import com.sistema.services.impl.RoleServiceImpl;
import com.sistema.services.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value = "/add-role.do")
public class AddRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoleService roleService = new RoleServiceImpl();;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddRoleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/add-role.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String description = request.getParameter("description");
		Role role = new Role();
		role.setDescription(description);
		Role roleCreated = roleService.save(role);
		if (roleCreated != null) {
			request.setAttribute("infoMessage", "Role created");
		} else {
			request.setAttribute("errorMessage", "An error has occurred");
		}
		request.getRequestDispatcher("/WEB-INF/views/add-role.jsp").forward(request, response);
	}

}
