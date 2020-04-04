package dto;

public class OrdersDateDifferenceDTO {
	
	private String customerid;
	private Integer differenceDates;
	public OrdersDateDifferenceDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrdersDateDifferenceDTO [customerid=" + customerid + ", differenceDates=" + differenceDates + "]";
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public int getDifferenceDates() {
		return differenceDates;
	}
	public void setDifferenceDates(Integer differenceDates) {
		this.differenceDates = differenceDates;
	}
	
	
	
	

}
