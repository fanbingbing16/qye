/**
 * 
 */
package com.abc.film.service;

import java.util.List;

import com.abc.film.domain.Device;
import com.abc.film.utils.Page;

/**
 * @author joeyang ong
 *
 */
public interface DeviceService {


	void removeDevice(String deviceId);

	byte[] getDevicePicById(String deviceId);
    List<Device> loadDevice(DeviceQry qry);

      Page loadPagedDevice(DeviceQry qry, Page page) ;



	
	
}
