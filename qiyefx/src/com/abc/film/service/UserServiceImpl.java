/**
 * 
 */
package com.abc.film.service;

import com.abc.film.dao.UserDao;
import com.abc.film.dao.UserDaoJDBCImpl;
import com.abc.film.domain.User;
import com.abc.film.exception.FilmException;

/**
 * @author joeyang ong
 *
 */
public class UserServiceImpl implements UserService {
	
	/* (non-Javadoc)
	 * @see com.abc.hotelsys.service.UserService#checkUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User checkUser(String userName, String userPassword) {
		
		UserDao userDao = new UserDaoJDBCImpl();
		User user = userDao.getUserByNo(userName);
		
		if(!user.getUserPassword().equals(userPassword))
			throw new FilmException("用户名找到，但是密码不正确，请检查!");
		
		return user;
	}

}
