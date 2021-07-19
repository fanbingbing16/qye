package com.abc.film.domain;

public class Device extends ValueObject{
	
	private String deviceCategory;/*类别*/
	private String deviceName;/*设备名称*/
	private String    deviceId;/*设备编号*/
	private byte[] deviceModel;/*设备型号*/
	private String deviceSpecificitions;/*设备规格*/
	private String shelfLife;/*保质期*/
	private String operator;/*经办人*/
	private String buyDate;/*购买日期*/
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	public String getDeviceCategory() {
		return deviceCategory;
	}
	public void setDeviceCategory(String deviceCategory) {
		this.deviceCategory = deviceCategory;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public String setDeviceId(String deviceId) {
		return this.deviceId = deviceId;
	}
	public byte[] getDeviceModel() {
		return deviceModel;
	}
	public void setDeviceModel(byte[] deviceModel) {
		this.deviceModel = deviceModel;
	}
	public String getDeviceSpecificitions() {
		return deviceSpecificitions;
	}
	public void setDeviceSpecificitions(String deviceSpecificitions) {
		this.deviceSpecificitions = deviceSpecificitions;
	}
	public String getShelfLife() {
		return shelfLife;
	}
	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	@Override
	public String toString() {
		return "Device [deviceCategory=" + deviceCategory + ", deviceName=" + deviceName + ", deviceId=" + deviceId
				+ ", deviceModel=" + deviceModel + ", deviceSpecificitions=" + deviceSpecificitions + ", shelfLife="
				+ shelfLife + ", operator=" + operator + "]";
	}
	
	
}
