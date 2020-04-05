package dto;

import java.util.Date;

public class CompanyOrderDateShipCountryDTO {

	
	private String companyname;
	private Date orderdate;
	private String shipcountry;
	public CompanyOrderDateShipCountryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public String getShipcountry() {
		return shipcountry;
	}
	public void setShipcountry(String shipcountry) {
		this.shipcountry = shipcountry;
	}
	@Override
	public String toString() {
		return "CompanyOrderDateShipCountryDTO [companyname=" + companyname + ", orderdate=" + orderdate
				+ ", shipcountry=" + shipcountry + "]";
	}
	
	
	
	
}
