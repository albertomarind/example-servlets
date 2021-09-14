package com.sistema.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "/SessionFilter", urlPatterns = "*.do")
public class SessionFilter implements Filter {
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpSession session = (HttpSession) httpServletRequest.getSession(false);
		if (session == null || session.getAttribute("user") == null) {
			httpServletRequest.getRequestDispatcher("/login.do").forward(httpServletRequest, httpServletResponse);
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
