package com.abc.film.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.abc.film.domain.Device;
import com.abc.film.service.DeviceQry;
import com.abc.film.utils.DBUtils;




public class DeviceDaoJDBC implements DeviceDao{
//	private static final String SQL_ADD_DEVICE 
//    = "insert into tbl_device(device_id,device_name,device_category,device_model,device_specificitions,shelf_life,operator,buy_date) values(?,?,?,?,?,?,?.?)";
private static final String SQL_LOAD_DEVICE
    ="select * from tbl_device order by device_id desc";
private static final String SQL_DEL_DEVICE_BYID
="delete from tbl_device where device_id=?";
private static final String SQL_LOAD_PIC_BYID
="select device_model from tbl_device where device_id=?";
private static final String SQL_ADD_DEVICE 
= "insert into tbl_buy(device_category,device_name,device_id,device_specificitions,shelf_life,operator,buy_date) values(?,?,?,?,?,?,?)";
	@Override
	public List<Device> loadDevice(DeviceQry qry) {
		
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Device> deviceList = new ArrayList<>();
		String sql = this.genSQLByQry(qry);
		System.out.println("loadrooms:"+sql);
		try {
			
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				
				Device device = new Device();
				device.setDeviceCategory(rset.getString("device_category"));
				device.setDeviceName(rset.getString("device_name"));
				
				device.setDeviceId(rset.getString("device_id"));
				
				device.setDeviceSpecificitions(rset.getString("device_specificitions"));
				device.setShelfLife(rset.getString("shelf_life"));
				device.setOperator(rset.getString("operator"));
				device.setBuyDate(rset.getString("Buy_Date"));
				deviceList.add(device);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, rset);
		}		
		
		return deviceList;
		
	}
	@Override
	public byte[] getDevicePicById(String deviceId) {
		
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		byte[] picData = null;
		
		try {
			
			pstmt = conn.prepareStatement(SQL_LOAD_PIC_BYID);
			pstmt.setString(1, deviceId);
			rset = pstmt.executeQuery();
			
			if (rset.next()){			
				picData = rset.getBytes("device_model");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, rset);
		}
			
		
		return picData;
		
	}

	@Override
	public void addDevice(Device device) {
		
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(SQL_ADD_DEVICE);
			pstmt.setString(1, device.getDeviceCategory());
			
			pstmt.setString(2, device.getDeviceName());
			pstmt.setString(3, device.getDeviceId());
			pstmt.setBytes(4, device.getDeviceModel());
			pstmt.setString(5, device.getDeviceSpecificitions());
			pstmt.setString(6, device.getShelfLife());
			pstmt.setString(7, device.getOperator());
			pstmt.setString(8, device.getBuyDate());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, null);
		}
		

	}
	@Override
	public void delDevice(String deviceId) {
		// TODO Auto-generated method stub

		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(SQL_DEL_DEVICE_BYID);
			pstmt.setString(1, deviceId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, null);
		}
	}
	
	/**
	 * 根据查询条件来自动生成对应的SQL语句
	 * @param helper
	 * @return
	 */
	private String genSQLByQry(DeviceQry qry){
		
		String sql = "select * from tbl_device where 1=1"; 
		
		if(qry.getDeviceqryCategory()!=null)
			 sql += " and device_category="+qry.getDeviceqryCategory();
		
		if(qry.getDeviceqryName()!=null)
			 sql += " and device_name='"+qry.getDeviceqryName()+"'";

		
		sql += " order by device_name desc";
		
		return sql;
		
	}	
	@Override
	public List<Device> loadScopedDevice(DeviceQry qry, int startIdx, int fetchSize) {
		
		String sql = this.genSQLByQry(qry);
		sql +=" limit ?,?";
		
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Device> deviceList = new ArrayList<>();
		DeviceDao deviceDao = new DeviceDaoJDBC();
		
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startIdx);
			pstmt.setInt(2, fetchSize);
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				
				Device device = new Device();
				device.setDeviceCategory(rset.getString("device_category"));
				device.setDeviceName(rset.getString("device_name"));
				
				device.setDeviceId(rset.getString("device_id"));
				
				device.setDeviceSpecificitions(rset.getString("device_specificitions"));
				device.setShelfLife(rset.getString("shelf_life"));
				device.setOperator(rset.getString("operator"));
				device.setBuyDate(rset.getString("Buy_Date"));
				deviceList.add(device);

							
			}		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, rset);
		}			
		
		return deviceList;
		
}
	@Override
	public long cntDeviceByCondition(DeviceQry qry) {
		
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = this.genSQLByQry(qry);
		//select * from tbl_rooms where .... order by room_id desc;
		//select count(*) from where ....
		sql = sql.replace("*", " count(*) as totalrec ");
		sql = sql.substring(0,sql.indexOf("order"));
		
		System.out.println("cntDeviceByCondition: "+sql);
		
		int deviceCnt=0;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				deviceCnt = rset.getInt("totalrec");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, rset);
		}		
		
		return deviceCnt;
	}



}
