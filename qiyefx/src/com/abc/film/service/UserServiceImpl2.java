/**
 * 
 */
package com.abc.film.service;

import com.abc.film.dao.UserDao;
import com.abc.film.dao.UserDao2;
import com.abc.film.dao.UserDaoJDBCImpl;
import com.abc.film.dao.UserDaoJDBCImpl2;
import com.abc.film.domain.User2;
import com.abc.film.exception.FilmException;

/**
 * @author joeyang ong
 *
 */
public class UserServiceImpl2 implements UserService2 {
	
	/* (non-Javadoc)
	 * @see com.abc.hotelsys.service.UserService#checkUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User2 checkUser2(String userName, String userPassword) {
		
		UserDao2 userDao2 = new UserDaoJDBCImpl2();
		User2 user = userDao2.getUser2ByNo(userName);
		
		if(!user.getUserPassword().equals(userPassword))
			throw new FilmException("用户名找到，但是密码不正确，请检查!");
		
		return user;
	}

}
