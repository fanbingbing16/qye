package com.abc.film.dao;

import java.util.List;


import com.abc.film.domain.Device;
import com.abc.film.service.DeviceQry;

public interface DeviceDao {

	List<Device> loadDevice(DeviceQry qry);

	void addDevice(Device device);

	byte[] getDevicePicById(String deviceId);

	void delDevice(String deviceId);

	List<Device> loadScopedDevice(DeviceQry qry, int startIdx, int fetchSize);

	long cntDeviceByCondition(DeviceQry qry);
	
	

}
