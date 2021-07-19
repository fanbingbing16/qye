package com.abc.film.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.abc.film.domain.Repair;
import com.abc.film.utils.DBUtils;

public class RepairDaoJDBC implements RepairDao{
	
	private static final String SQL_ADD_REPAIR
    = "insert into tbl_repair(device_id,device_name,repair_date,repair_facture,repair_money,person_liable) values(?,?,?,?,?,?)";
private static final String SQL_LOAD_REPAIR
    ="select * from tbl_repair order by device_id desc";

/* (non-Javadoc)
 * @see com.abc.hotelsys.dao.HotelDao#addHotel(com.abc.hotelsys.domain.Hotel)
 */
@Override
public void addRepair(Repair repair) {
	
	Connection conn = DBUtils.getConn();
	PreparedStatement pstmt = null;
	
	try {
		pstmt = conn.prepareStatement(SQL_ADD_REPAIR);
		pstmt.setString(1, repair.getDeviceId());
		pstmt.setString(2, repair.getDeviceName());
		pstmt.setString(3, repair.getRepairDate());
		pstmt.setString(4, repair.getRepairFacture());
		pstmt.setString(5,repair.getRepairMoney());
		
		pstmt.setString(6, repair.getPersonLiable());
		
		
		pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally{
		DBUtils.releaseRes(conn, pstmt, null);
	}
}
@Override
public List<Repair> loadRepair() {
	
	Connection conn = DBUtils.getConn();
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	List<Repair> repairList = new ArrayList<>();
	
	try {
		
		pstmt = conn.prepareStatement(SQL_LOAD_REPAIR);
		rset = pstmt.executeQuery();
		
		while(rset.next()){
			
			Repair repair = new Repair();
			repair.setDeviceId(rset.getString("device_id"));
			repair.setDeviceName(rset.getString("device_name"));
			repair.setRepairDate(rset.getString("repair_date"));
			
			repair.setRepairFacture(rset.getString("repair_facture"));
			repair.setRepairMoney(rset.getString("repair_money"));
			repair.setPersonLiable(rset.getString("person_liable"));
			repairList.add(repair);
			System.out.println("ok!");
			
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally{
		DBUtils.releaseRes(conn, pstmt, rset);
	}		
	System.out.print("111"+repairList+"222");
	return repairList;
	
}
}
