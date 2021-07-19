package com.abc.film.dao;

import java.util.List;

import com.abc.film.domain.Buy;

public interface BuyDao {
	void addBuy(Buy buy);

	List<Buy> loadBuy();

	void updateBuy(Buy buy);

	void delBuy(String deviceId);

	Buy getBuyById(String deviceId);
	
}
