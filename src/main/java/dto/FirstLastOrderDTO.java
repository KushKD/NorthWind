package dto;

import java.util.Date;

public class FirstLastOrderDTO {
	
	private String firstName;
	private String lastName;
	private Date orderDate;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "FirstLastOrderDTO [firstName=" + firstName + ", lastName=" + lastName + ", orderDate=" + orderDate
				+ "]";
	}
	
	
	
	

}
