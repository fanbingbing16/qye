package com.abc.film.domain;

public class Device extends ValueObject{
	
	private String deviceCategory;/*���*/
	private String deviceName;/*�豸����*/
	private String    deviceId;/*�豸���*/
	private byte[] deviceModel;/*�豸�ͺ�*/
	private String deviceSpecificitions;/*�豸���*/
	private String shelfLife;/*������*/
	private String operator;/*������*/
	private String buyDate;/*��������*/
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
