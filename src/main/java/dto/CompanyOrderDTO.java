package dto;

public class CompanyOrderDTO {
	
	private String companyName;
	private Integer orderid;
	public CompanyOrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CompanyOrderDTO [companyName=" + companyName + ", orderid=" + orderid + "]";
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	
	

}
