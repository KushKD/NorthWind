package com.kush.northwind;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@Column(name="customerid")
	private String cutomer_id;
	
	@Column(name="companyname")
	private String companyName;
	
	@Column(name="contactname")
	private String contactName;
	
	@Column(name="contacttitle")
	private String contactTitle;
	
	@Column(name="address")
	private String address;
	
	@Column(name="city")
	private String city;
	
	@Column(name="postalcode")
	private String postalcode;
	
	@Column(name="country")
	private String country;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="fax")
	private String fax;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String cutomer_id, String companyName, String contactName, String contactTitle, String address,
			String city, String postalcode, String country, String phone, String fax) {
		super();
		this.cutomer_id = cutomer_id;
		this.companyName = companyName;
		this.contactName = contactName;
		this.contactTitle = contactTitle;
		this.address = address;
		this.city = city;
		this.postalcode = postalcode;
		this.country = country;
		this.phone = phone;
		this.fax = fax;
	}

	public String getCutomer_id() {
		return cutomer_id;
	}

	public void setCutomer_id(String cutomer_id) {
		this.cutomer_id = cutomer_id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactTitle() {
		return contactTitle;
	}

	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Override
	public String toString() {
		return "Customer [cutomer_id=" + cutomer_id + ", companyName=" + companyName + ", contactName=" + contactName
				+ ", contactTitle=" + contactTitle + ", address=" + address + ", city=" + city + ", postalcode="
				+ postalcode + ", country=" + country + ", phone=" + phone + ", fax=" + fax + "]";
	}
	
	

	

}
