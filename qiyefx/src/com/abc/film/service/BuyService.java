/**
 * 
 */
package com.abc.film.service;

import com.abc.film.domain.Buy;

/**
 * @author joeyang ong
 *
 */
public interface BuyService {

	void removeBuy(String userId);

	void updateBuy(Buy buy);

	Buy getBuyById(String userId);

	
	
}
