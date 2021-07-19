/**
 * 
 */
package com.abc.film.service;

import java.util.List;

import com.abc.film.dao.BuyDao;
import com.abc.film.dao.BuyDaoJDBC;
import com.abc.film.dao.DeviceDao;
import com.abc.film.dao.DeviceDaoJDBC;
import com.abc.film.domain.Device;
import com.abc.film.utils.Page;

/**
 * @author joeyang ong
 *
 */
public class DeviceServiceImpl implements DeviceService {

	/* (non-Javadoc)
	 * @see com.abc.hotelsys.service.HotelService#removeHotel()
	 */
	@Override
	public void removeDevice(String deviceId) {
		
		DeviceDao deviceDao = new DeviceDaoJDBC();
		deviceDao.delDevice(deviceId);

	}
	@Override
	public byte[] getDevicePicById(String deviceId) {
		DeviceDao deviceDao = new DeviceDaoJDBC();
		return deviceDao.getDevicePicById(deviceId);
	}
	@Override
	public List<Device> loadDevice(DeviceQry qry) {
		
		DeviceDao deviceDao = new DeviceDaoJDBC();
		return deviceDao.loadDevice(qry);

	}
	@Override
	public Page loadPagedDevice(DeviceQry qry, Page page) {
		// TODO Auto-generated method stub
		DeviceDao deviceDao = new DeviceDaoJDBC();
	 		
	    page.setTotalRecNum(deviceDao.cntDeviceByCondition(qry));
	    page.setPageContent(deviceDao.loadScopedDevice(qry, page.getStartIndex(), page.getPageSize()));
	 		
	 	return page;
	}


}
