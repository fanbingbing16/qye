package com.abc.film.dao;



import java.util.List;

import com.abc.film.domain.Repair;


public interface RepairDao {

	void addRepair(Repair repair);

	List<Repair> loadRepair();
	
	

}

