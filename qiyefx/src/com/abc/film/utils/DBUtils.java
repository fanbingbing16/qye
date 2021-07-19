package com.abc.film.utils;
import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
public class DBUtils {
	/**
	 * 
	 */

		
		//���Ӵ�
		// mysql 5.0: jdbc:mysql://localhost:3306/zsb2018
		private static final String CONN_URL = "jdbc:mysql://localhost:3306/film_device?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
		private static final String USER = "root";
		private static final String PWD = "111";
		
		
		/**
		 * �������
		 * @return
		 */
		public static Connection getConn(){
			
			Connection conn = null;
			
			try {
				//���ݿ����������һ����һ��jar������ʵjava�������ĳ�����ݿ��������
				//mysql 8.0: com.mysql.cj.jdbc.Driver
				//mysql 5.0: com.mysql.jdbc.Driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(CONN_URL, USER, PWD);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return conn;
			
		}
		
		
		/**
		 * �ͷ���Դ
		 * @param conn
		 * @param pstmt
		 * @param rset
		 */
		public static void releaseRes(Connection conn, PreparedStatement pstmt, ResultSet rset){
			

				try {
					if(rset!=null) rset.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		}
		
		

	}


