package com.example.csv.domain;

public class Bank{
	private String id;
	private String Type;
	private String City;
	private String State;
	private String ZipCode;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBankName() {
		return BankName;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getZipCode() {
		return ZipCode;
	}
	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}
	private String BankName;
	@Override
	public String toString() {
		return "Bank [id=" + id + ", BankName=" + BankName + ", Type=" + Type + ", City=" + City + ", State=" + State
				+ ", ZipCode=" + ZipCode + "]";
	}
	
}
