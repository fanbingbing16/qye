package com.abc.film.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.film.dao.BuyDao;
import com.abc.film.dao.BuyDaoJDBC;
import com.abc.film.domain.Buy;
import com.abc.film.service.BuyService;
import com.abc.film.service.BuyServiceImpl;





/**
 * Servlet implementation class BuyNarServlet
 */
@WebServlet("/buyMgr")
public class BuyMgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyMgrServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param  
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		
		String task = request.getParameter("task");
		
		if("toInput".equals(task)){
			request.getRequestDispatcher("WEB-INF/views/hotel/input_hotel.jsp").forward(request, response);
		}
		else if("createBuy".equals(task)){
//			System.out.println("create hotel now!");
			Buy buy = new Buy();
			 buy.setUserId(request.getParameter("userid"));
				buy.setUserPaw(request.getParameter("userpaw"));
				buy.setUserAnser(request.getParameter("useranser"));
				
				buy.setUserAnser2(request.getParameter("useranser2"));
			
			System.out.println(buy);
			
			BuyDao buyDao = new BuyDaoJDBC();
		    buyDao.addBuy(buy);
			
			response.sendRedirect("buyMgr?task=loadBuy");
			
		}
         else if("loadBuy".equals(task)){
			
			BuyDao buyDao = new BuyDaoJDBC();
			List<Buy> buyList = buyDao.loadBuy();
			
			request.setAttribute("buyList", buyList);

			request.getRequestDispatcher("list_buy.jsp").forward(request, response);
			
		}
         else if("removeBuy".equals(task)){ // hotelMgr?task=removeHotel&hotelid=2   request.getParameter("deviceid")
 			
        	 Buy buy = new Buy();
  			String userId = buy.setUserId(request.getParameter("userid"));
 			
// 			System.out.println("removehotel ,hotelid="+hotelId);
 			BuyService buyService = new BuyServiceImpl();
 			buyService.removeBuy(userId);
 			
 			response.sendRedirect("buyMgr?task=loadBuy");
 			
 			
 			
 		}
         else if("updateBuy".equals(task)){
        	 Buy buy = new Buy();
        	 buy.setUserId(request.getParameter("userid"));
				buy.setUserPaw(request.getParameter("userpaw"));
				buy.setUserAnser(request.getParameter("useranser"));
				
				buy.setUserAnser2(request.getParameter("useranser2"));
 			
 			System.out.println(buy);
 			
 			
 			BuyService buyService = new BuyServiceImpl();
			buyService.updateBuy(buy);
 			
 			System.out.print("this!");
 			
// 		   request.getRequestDispatcher("update_buy.jsp").forward(request, response);
 			
 			
 			response.sendRedirect("buyMgr?task=loadBuy");
 			
 		}
         else if("preUpdateBuy".equals(task)){
        	 Buy buy = new Buy();
   			String deviceId = buy.setUserId(request.getParameter("userid"));
 			
 			BuyService buyService = new BuyServiceImpl();
 			Buy buy2 = buyService.getBuyById(deviceId);
 			
 			request.setAttribute("device", buyService.getBuyById(deviceId));
 			
 			request.getRequestDispatcher("update_buy.jsp").forward(request, response);
 			
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
