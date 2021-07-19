package com.abc.film.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.abc.film.domain.Buy;
import com.abc.film.utils.DBUtils;



public class BuyDaoJDBC implements BuyDao {

	

		private static final String SQL_ADD_BUY 
	    = "insert into tbl_buy(user_id,user_paw,user_anser,user_anser2) values(?,?,?,?)";
    private static final String SQL_LOAD_BUY
        ="select * from tbl_buy order by user_id desc";
    private static final String SQL_DEL_BUY_BYID
    ="delete from tbl_buy where user_id=?";
	private static final String SQL_UPDATE
	  = "update tbl_buy set user_id=?,user_paw=?,user_anser=?,user_anser2=?";

	 private static final String SQL_GET_BYID = "select * from tbl_buy where user_id=?";
	/* (non-Javadoc)
	 * @see com.abc.hotelsys.dao.HotelDao#addHotel(com.abc.hotelsys.domain.Hotel)
	 */
	@Override
	public void addBuy(Buy buy) {
		
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(SQL_ADD_BUY);
			pstmt.setString(1, buy.getUserId());
			
			pstmt.setString(2, buy.getUserPaw());
			pstmt.setString(3, buy.getUserAnser());
			pstmt.setString(4, buy.getUserAnser2());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, null);
		}
		

	}
	@Override
	public List<Buy> loadBuy() {
		
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Buy> buyList = new ArrayList<>();
		
		try {
			
			pstmt = conn.prepareStatement(SQL_LOAD_BUY);
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				
				Buy buy = new Buy();
				buy.setUserId(rset.getString("user_id"));
				buy.setUserPaw(rset.getString("user_paw"));
				buy.setUserAnser(rset.getString("user_anser"));
				
				buy.setUserAnser2(rset.getString("user_anser2"));
				
				
				buyList.add(buy);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, rset);
		}		
		
		return buyList;
		
	}
	
	@Override
	public void updateBuy(Buy buy) {

		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, buy.getUserId());
			pstmt.setString(2, buy.getUserPaw());
			//['a','b','c'] ->a|b|c
						
			pstmt.setString(3, buy.getUserAnser());
			
			pstmt.setString(4, buy.getUserAnser2());
			
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
				
		} finally{
			DBUtils.releaseRes(conn, pstmt, null);
		}		
//		
	}
	@Override
	public void delBuy(String userId) {
		// TODO Auto-generated method stub

		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(SQL_DEL_BUY_BYID);
			pstmt.setString(1, userId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, null);
		}
	}
	@Override
	public Buy getBuyById(String userId) {
		// TODO Auto-generated method stub

		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Buy buy = null;
		
		try {
			
			pstmt = conn.prepareStatement(SQL_GET_BYID);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery(); 
			
			if(rset.next()){
				buy = new Buy();
				buy.setUserId(rset.getString("user_id"));
				buy.setUserPaw(rset.getString("user_paw"));
				buy.setUserAnser(rset.getString("user_anser"));
				
				buy.setUserAnser2(rset.getString("user_anser2"));
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, rset);
		}
		
		return buy;
	}
	

}
