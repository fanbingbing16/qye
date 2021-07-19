/**
 * 
 */
package com.abc.film.service;

import com.abc.film.dao.BuyDao;
import com.abc.film.dao.BuyDaoJDBC;
import com.abc.film.domain.Buy;

/**
 * @author joeyang ong
 *
 */
public class BuyServiceImpl implements BuyService {

	/* (non-Javadoc)
	 * @see com.abc.hotelsys.service.HotelService#removeHotel()
	 */
	@Override
	public void removeBuy(String userId) {
		
		BuyDao buyDao = new BuyDaoJDBC();
		buyDao.delBuy(userId);

	}
	@Override
	public void updateBuy(Buy buy) {

		BuyDao buyDao = new BuyDaoJDBC();
		buyDao.updateBuy(buy);
		
	}
	@Override
	public Buy getBuyById(String userId) {
		// TODO Auto-generated method stub
		BuyDao buyDao = new BuyDaoJDBC();
		return buyDao.getBuyById(userId);
		
	}

}
