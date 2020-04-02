package com.kush.northwind;

import java.sql.Date;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employees {

	@Id
	@Column(name="employeeid")
	private int employeeid;
	
	@Column(name="lastname")
	private String last_name;
	
	@Column(name="firstname")
	private String first_name;
	
	@Column(name="title")
	private String title;
	
	@Column(name="titleofcourtesy")
	private String titleOfCourtsey;
	
	@Column(name="birthdate")
	private Date birthDate;
	
	@Column(name="hiredate")
	private Date hireDate;
	
	@Column(name="address")
	private String address;
	
	@Column(name="city")
	private String city;
	
	@Column(name="region")
	private String region;
	
	@Column(name="pincode")
	private String pincode;
	
	@Column(name="country")
	private String country;
	
	@Column(name="homephone")
	private String homephone;
	
	@Column(name="extension")
	private String extention;
	
	@Column(name="photo")
	private byte[] photo;
	
	@Column(name="notes")
	private String notes;
	
	@Column(name="reportsto")
	private Integer reportsto;
	
	@Column(name="photopath")
	private String photopath;
	
	

	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Employees(int employeeid, String last_name, String first_name, String title, String titleOfCourtsey,
			Date birthDate, Date hireDate, String address, String city, String region, String pincode, String country,
			String homephone, String extention, byte[] photo, String notes, int reportsto, String photopath) {
		super();
		this.employeeid = employeeid;
		this.last_name = last_name;
		this.first_name = first_name;
		this.title = title;
		this.titleOfCourtsey = titleOfCourtsey;
		this.birthDate = birthDate;
		this.hireDate = hireDate;
		this.address = address;
		this.city = city;
		this.region = region;
		this.pincode = pincode;
		this.country = country;
		this.homephone = homephone;
		this.extention = extention;
		this.photo = photo;
		this.notes = notes;
		this.reportsto = reportsto;
		this.photopath = photopath;
	}



	public int getEmployeeid() {
		return employeeid;
	}



	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getTitleOfCourtsey() {
		return titleOfCourtsey;
	}



	public void setTitleOfCourtsey(String titleOfCourtsey) {
		this.titleOfCourtsey = titleOfCourtsey;
	}



	public Date getBirthDate() {
		return birthDate;
	}



	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}



	public Date getHireDate() {
		return hireDate;
	}



	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
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



	public String getRegion() {
		return region;
	}



	public void setRegion(String region) {
		this.region = region;
	}



	public String getPincode() {
		return pincode;
	}



	public void setPincode(String pincode) {
		this.pincode = pincode;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getHomephone() {
		return homephone;
	}



	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}



	public String getExtention() {
		return extention;
	}



	public void setExtention(String extention) {
		this.extention = extention;
	}



	public byte[] getPhoto() {
		return photo;
	}



	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}



	public String getNotes() {
		return notes;
	}



	public void setNotes(String notes) {
		this.notes = notes;
	}



	public int getReportsto() {
		return reportsto;
	}



	public void setReportsto(int reportsto) {
		this.reportsto = reportsto;
	}



	public String getPhotopath() {
		return photopath;
	}



	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}



	@Override
	public String toString() {
		return "Employees [employeeid=" + employeeid + ", last_name=" + last_name + ", first_name=" + first_name
				+ ", title=" + title + ", titleOfCourtsey=" + titleOfCourtsey + ", birthDate=" + birthDate
				+ ", hireDate=" + hireDate + ", address=" + address + ", city=" + city + ", region=" + region
				+ ", pincode=" + pincode + ", country=" + country + ", homephone=" + homephone + ", extention="
				+ extention + ", photo=" + Arrays.toString(photo) + ", notes=" + notes + ", reportsto=" + reportsto
				+ ", photopath=" + photopath + "]";
	}
	
	
	
	
	

}
