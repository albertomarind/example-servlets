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
@WebServlet(value = "/add-user.do")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoleService roleService = new RoleServiceImpl();
	private UserService userService = new UserServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUserServlet() {
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
		request.getRequestDispatcher("/WEB-INF/views/add-user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String idRole = request.getParameter("idRole");
		Role role = new Role();
		role.setId(Integer.valueOf(idRole));
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(role);
		User userCreated = userService.save(user);
		if (userCreated != null) {
			request.setAttribute("infoMessage", "User created");
		} else {
			request.setAttribute("errorMessage", "An error has occurred");
		}
		request.getRequestDispatcher("/WEB-INF/views/add-user.jsp").forward(request, response);
	}

}
