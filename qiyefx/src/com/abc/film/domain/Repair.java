package com.abc.film.domain;

public class Repair extends ValueObject{
	
	private String deviceId;/*��Ʒ���*/
	private String deviceName;/*��Ʒ����*/
	private String repairDate;/*��������*/

	

	private String repairFacture;/*��������*/

	private String repairMoney;/*��������*/

	private String personLiable;/*������*/

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
