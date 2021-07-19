package com.abc.film.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.film.dao.RepairDao;
import com.abc.film.dao.RepairDaoJDBC;
import com.abc.film.domain.Repair;

/**
 * Servlet implementation class RepairNgrServlet
 */

@WebServlet("/repairMgr")
public class RepairMgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RepairMgrServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
request.setCharacterEncoding("utf-8");
		
		String task = request.getParameter("task");
		
		if("toInput".equals(task)){
			request.getRequestDispatcher("input_hotel.jsp").forward(request, response);
		}
		else if("createRepair".equals(task)){
//			System.out.println("create hotel now!");
			Repair repair = new Repair();
			repair.setDeviceId(request.getParameter("deviceid"));
			repair.setDeviceName(request.getParameter("devicename"));
			repair.setRepairDate(request.getParameter("repairdate"));
			repair.setRepairFacture(request.getParameter("repairfacture"));
			repair.setRepairMoney(request.getParameter("repairmoney"));
			repair.setPersonLiable(request.getParameter("personliable"));
			
			System.out.println(repair);
			
			RepairDao repairDao = new RepairDaoJDBC();
		    repairDao.addRepair(repair);
			
			response.sendRedirect("repairMgr?task=loadRepair");
			System.out.println("complet!");
		}
       else if("loadRepair".equals(task)){
			
			RepairDao repairDao = new RepairDaoJDBC();
			List<Repair> repairList = repairDao.loadRepair();
			
			request.setAttribute("repairList", repairList);

			request.getRequestDispatcher("list_repair.jsp").forward(request, response);
			System.out.println("aaa!");
			
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
