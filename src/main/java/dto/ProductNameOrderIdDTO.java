package dto;

public class ProductNameOrderIdDTO {
	
	private Integer orderid;
	private String productname;
	public ProductNameOrderIdDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	@Override
	public String toString() {
		return "ProductNameOrderIdDTO [orderid=" + orderid + ", productname=" + productname + "]";
	}
	
	

}
