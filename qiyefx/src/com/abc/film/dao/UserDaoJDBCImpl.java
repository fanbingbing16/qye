/**
 * 
 */
package com.abc.film.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.abc.film.domain.User;
import com.abc.film.domain.User2;
import com.abc.film.exception.DataAccessException;
import com.abc.film.utils.DBUtils;

/**
 * @author joeyang ong
 *
 */
public class UserDaoJDBCImpl implements UserDao {
	
	private static final String SQL_LOAD_BYNO = "select * from film_user where user_name=?";

	/* (non-Javadoc)
	 * @see com.abc.hotelsys.dao.UserDao#getUserByNo(java.lang.String)
	 */
	@Override
	public User getUserByNo(String userName ) {
		
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		User user=null;
		
		try {
			
			pstmt = conn.prepareStatement(SQL_LOAD_BYNO);
			pstmt.setString(1, userName);
			rset = pstmt.executeQuery();
			System.out.println("aaa");
			if(rset.next()){
				user = new User();
				user.setUserName(rset.getString("user_name"));
				user.setUserPassword(rset.getString("user_password"));
			    System.out.println("111");
			}
			else
			    throw new DataAccessException("���Ϊ"+userName+"���û������ڣ�����!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, rset);
		}	
		System.out.println(userName);
		return user;
	}



}
