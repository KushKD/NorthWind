package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="order_details")
public class OrderDetails {
	
	@Id
	@Column(name="orderid")
	private Integer orderid	;
	
	@Column(name="productid")
	private Integer productid;	
	
	@Column(name="unitprice")
	private Float unitprice;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="discount")
	private Float discount; 
	
	@OneToOne(targetEntity = Products.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//@Fetch(FetchMode.SUBSELECT)
	@JoinColumn(name = "productid", updatable = false, insertable = false)
	private Products products;
	
	



	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderid=" + orderid + ", productid=" + productid + ", unitprice=" + unitprice
				+ ", quantity=" + quantity + ", discount=" + discount + "]";
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Float getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Float unitprice) {
		this.unitprice = unitprice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
