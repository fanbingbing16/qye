package com.abc.film.domain;

public class Repair extends ValueObject{
	
	private String deviceId;/*商品编号*/
	private String deviceName;/*商品名称*/
	private String repairDate;/*生产日期*/

	

	private String repairFacture;/*生产工厂*/

	private String repairMoney;/*生产费用*/

	private String personLiable;/*责任人*/

	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String string) {
		this.deviceId = string;
	}
	
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getRepairDate() {
		return repairDate;
	}
	public void setRepairDate(String repairDate) {
		this.repairDate = repairDate;
	}
	public String getRepairFacture() {
		return repairFacture;
	}
	public void setRepairFacture(String repairFacture) {
		this.repairFacture = repairFacture;
	}
	public String getRepairMoney() {
		return repairMoney;
	}
	public void setRepairMoney(String repairMoney) {
		this.repairMoney = repairMoney;
	}
	public String getPersonLiable() {
		return personLiable;
	}
	public void setPersonLiable(String personLiable) {
		this.personLiable = personLiable;
	}
	
	
}
