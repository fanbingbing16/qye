package com.abc.film.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.film.exception.FilmException;
import com.abc.film.domain.User;
import com.abc.film.service.UserService;
import com.abc.film.service.UserServiceImpl;

/**
 * Servlet implementation class SecurityMgrServlet
 */
@WebServlet("/securityMgr")
public class SecurityMgrServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String task = request.getParameter("task");
		
		if("toLogin".equals(task)){
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else if("login".equals(task)){
			
			String userName = request.getParameter("username");
			String userPassword = request.getParameter("userpassword");
			
			UserService userService = new UserServiceImpl();
			try{
			   User user = userService.checkUser(userName, userPassword);
			   request.getSession().setAttribute("user", user);
			   response.sendRedirect("securityMgr?task=main");
			}catch(FilmException e){
			   request.setAttribute("errMsg", e.getMessage());
			   request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
		}
		else if("main".equals(task)){
			request.getRequestDispatcher("login_list.html").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
