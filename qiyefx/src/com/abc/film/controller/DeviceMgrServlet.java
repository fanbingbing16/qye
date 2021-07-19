package com.abc.film.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.abc.film.dao.DeviceDao;
import com.abc.film.dao.DeviceDaoJDBC;
import com.abc.film.domain.Device;
import com.abc.film.service.BuyService;
import com.abc.film.service.BuyServiceImpl;
import com.abc.film.service.DeviceQry;
import com.abc.film.service.DeviceService;
import com.abc.film.service.DeviceServiceImpl;
import com.abc.film.utils.Page;
import com.mysql.cj.util.StringUtils;


/**
 * Servlet implementation class DeviceMgrServlet
 */
@WebServlet("/deviceMgr")
public class DeviceMgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeviceMgrServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
           request.setCharacterEncoding("utf-8");
   		
   		//��ʼ��SFU
   		//��õ�ǰWEB����������ʱ�ļ��е�λ��
   		File tempFile=new File(System.getProperty("java.io.tmpdir"));
   		
   		//��fileupload���߿��У��κ�һ����������һ�������ļ���
   		DiskFileItemFactory factory=new DiskFileItemFactory();
   		//����ܹ�֧��һ�����ṩ4096�������ļ���
   		factory.setSizeThreshold(4096);	
   		//�ṩ��ʱ�ļ���λ�ã��Է������
   		factory.setRepository(tempFile);	
   		//����sfu,��factory
   		ServletFileUpload sfu=new ServletFileUpload(factory);
   		//���õ��ļ��ϴ���������
   		sfu.setSizeMax(5000000);		
   		
   		List<FileItem> fileItems=null; 
   		String task = null;
   		
   		if(sfu.isMultipartContent(request)) //�ж�request�Ƿ��Ƕ���ύ
   		{
   			try {
   				fileItems=sfu.parseRequest(request); //��������й��ˣ�������е�fileitem.
   				for(FileItem item:fileItems)
   				{
   					if(item.isFormField() && item.getFieldName().equals("task"))
                       {
                       	task=item.getString("utf-8");
                       	break;
                       } 					
   				}
   			} catch (FileUploadException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
   			
   		}
   		else
   		    task=request.getParameter("task").trim();	
   		
		  if("toInput".equals(task)){
				request.getRequestDispatcher("WEB-INF/views/hotel/input_hotel.jsp").forward(request, response);
			}
		  else if("createDevice".equals(task)){
//				System.out.println("create hotel now!");
			  Device device = new Device();
			 
					  device.setDeviceCategory(request.getParameter("devicecategory"));
				 
			    device.setDeviceName(request.getParameter("devicename"));
			   
				device.setDeviceId(request.getParameter("deviceid"));
				
               device.setDeviceModel(null);	
			
			
				device.setBuyDate(request.getParameter("buydate"));
			  
				System.out.println(device);
				
				DeviceDao deviceDao = new DeviceDaoJDBC();
			    deviceDao.addDevice(device);
				
				response.sendRedirect("deviceMgr?task=loadDevice");
				
			}
		  else if("removeDevice".equals(task)){ // hotelMgr?task=removeHotel&hotelid=2   request.getParameter("deviceid")
	 			
	        	 Device device = new Device();
	  			String deviceId = device.setDeviceId(request.getParameter("deviceid"));
	 			
//	 			System.out.println("removehotel ,hotelid="+hotelId);
	 			BuyService buyService = new BuyServiceImpl();
	 			buyService.removeBuy(deviceId);
	 			
	 			response.sendRedirect("deviceMgr?task=loadDevice");
	 			
	 			
	 			
	 		}
		  else if("loadDevice".equals(task)){
			  DeviceQry qry = new DeviceQry();
			//������������ݣ���װ��ѯ��������
			if(!StringUtils.isNullOrEmpty(request.getParameter("DeviceqryCategory")))
			qry.setDeviceqryCategory(request.getParameter("DeviceqryCategory"));
			else if(!StringUtils.isNullOrEmpty(request.getParameter("DeviceqryName")))
			qry.setDeviceqryName(request.getParameter("DeviceqryName"));
			
			DeviceDao deviceDao = new DeviceDaoJDBC();
			DeviceService deviceService=new DeviceServiceImpl();
           Page page = new Page();
			
			if(!StringUtils.isNullOrEmpty(request.getParameter("pageno")))
				page.setPageNo(Integer.parseInt(request.getParameter("pageno")));
						
			page=deviceService.loadPagedDevice(qry, page);

			List<Device> deviceList = deviceDao.loadDevice(qry);
			request.setAttribute("page", page);
			request.setAttribute("deviceList", deviceList);

			request.getRequestDispatcher("list_device.jsp").forward(request, response);
			
		}
		  else if("loadPic".equals(task)){ //hotelMgr?task=loadPic&hotelid=123
			  String deviceId=request.getParameter(request.getParameter("deviceid"));
				 
				
				DeviceService deviceService = new DeviceServiceImpl();
				byte[] pic = deviceService.getDevicePicById(deviceId);
				
				if(pic==null ||pic.length==0){
					String defaultPicPath = request.getRealPath("/")+"pics/1.JPG"; //��ʵ����·������ҳ·��֮��Ĳ��졣
					FileInputStream fis =new FileInputStream(defaultPicPath);
					pic=new byte[fis.available()];
					fis.read(pic);
				}
				
				response.setContentType("image/jpeg");
				OutputStream out = response.getOutputStream();
			    out.write(pic);
			    out.flush();
			    out.close();
				
			}
		  else if("load2Device".equals(task)){
			  DeviceQry qry = new DeviceQry();
			//������������ݣ���װ��ѯ��������
			if(!StringUtils.isNullOrEmpty(request.getParameter("DeviceqryCategory")))
			qry.setDeviceqryCategory(request.getParameter("DeviceqryCategory"));
			else if(!StringUtils.isNullOrEmpty(request.getParameter("DeviceqryName")))
			qry.setDeviceqryName(request.getParameter("DeviceqryName"));
			
			DeviceDao deviceDao = new DeviceDaoJDBC();
			DeviceService deviceService=new DeviceServiceImpl();
           Page page = new Page();
			
			if(!StringUtils.isNullOrEmpty(request.getParameter("pageno")))
				page.setPageNo(Integer.parseInt(request.getParameter("pageno")));
						
			page=deviceService.loadPagedDevice(qry, page);

			List<Device> deviceList = deviceDao.loadDevice(qry);
			request.setAttribute("page", page);
			request.setAttribute("deviceList", deviceList);

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
