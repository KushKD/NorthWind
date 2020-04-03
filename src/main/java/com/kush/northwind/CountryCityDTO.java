package com.kush.northwind;

public class CountryCityDTO {
	
	private String country;
	private String city;
	public CountryCityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "CountryCityDTO [country=" + country + ", city=" + city + "]";
	}
	
	

}
