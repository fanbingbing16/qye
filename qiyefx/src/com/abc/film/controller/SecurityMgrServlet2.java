package com.abc.film.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.film.exception.FilmException;
import com.abc.film.domain.User;
import com.abc.film.domain.User2;
import com.abc.film.service.UserService;
import com.abc.film.service.UserService2;
import com.abc.film.service.UserServiceImpl;
import com.abc.film.service.UserServiceImpl2;

/**
 * Servlet implementation class SecurityMgrServlet
 */
@WebServlet("/security2Mgr")
public class SecurityMgrServlet2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String task = request.getParameter("task");
		
		if("toLogin".equals(task)){
			request.getRequestDispatcher("index2.jsp").forward(request, response);
		}
		else if("login2".equals(task)){
			
			String userName = request.getParameter("username");
			String userPassword = request.getParameter("userpassword");
			
			UserService2 userService = new UserServiceImpl2();
			try{
			   User2 user = userService.checkUser2(userName, userPassword);
			   request.getSession().setAttribute("user", user);
			   response.sendRedirect("security2Mgr?task=main");
			}catch(FilmException e){
			   request.setAttribute("errMsg", e.getMessage());
			   request.getRequestDispatcher("index2.jsp").forward(request, response);
			}
			
		}
		else if("main".equals(task)){
			request.getRequestDispatcher("list_device2.jsp").forward(request, response);
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
