package com.kush.northwind;

import java.io.Serializable;

public class SupplierDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String city;
	private String county;
	private String companyName;
	public SupplierDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Override
	public String toString() {
		return "SupplierDTO [city=" + city + ", county=" + county + ", companyName=" + companyName + "]";
	}
	
	

}
