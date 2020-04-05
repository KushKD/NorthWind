package entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Formula;

@Entity
@Table(name="orders")
public class Orders {
	 
	@Id
	@Column(name="orderid")
	private Integer orderid	;
	
	@Column(name="customerid")
	private String customerid;	
	
	@Column(name="employeeid")
	private Integer employeeid;	
	
	@Column(name="orderdate")
	private Date orderdate	;
	
	@Column(name="requireddate")
	private Date requireddate;
	
	@Column(name="shippeddate")
	private Date shippeddate;
	
	@Formula("shippeddate - orderdate")
	private Integer differenceDates;
	
	@Column(name="shipvia")
	private Integer shipvia	;
	
	@Column(name="freight")
	private Float freight	;
	
	@Column(name="shipname")
	private String shipname	;
	
	@Column(name="shipaddress")
	private String shipaddress;
	
	@Column(name="shipcity")
	private String shipcity		;
	
	@Column(name="shipregion")
	private String shipregion	;
	
	@Column(name="shippostalcode")
	private String shippostalcode;
	
	@Column(name="shipcountry")
	private String shipcountry;
	
	@OneToMany(targetEntity = OrderDetails.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	@JoinColumn(name = "orderid", updatable = false, insertable = false)
	private List<OrderDetails> order_details;
	
	@OneToOne(targetEntity = Customer.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT) 
	@JoinColumn(name = "cutomer_id", updatable = false, insertable = false)
	private Customer cname;
	
	
	

	public List<OrderDetails> getOrder_details() {
		return order_details;
	}


	public void setOrder_details(List<OrderDetails> order_details) {
		this.order_details = order_details;
	}


	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Integer getDifferenceDates() {
		return differenceDates;
	}


	public void setDifferenceDates(Integer differenceDates) {
		this.differenceDates = differenceDates;
	}


	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public Integer getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public Date getRequireddate() {
		return requireddate;
	}
	public void setRequireddate(Date requireddate) {
		this.requireddate = requireddate;
	}
	public Date getShippeddate() {
		return shippeddate;
	}
	public void setShippeddate(Date shippeddate) {
		this.shippeddate = shippeddate;
	}
	public Integer getShipvia() {
		return shipvia;
	}
	public void setShipvia(Integer shipvia) {
		this.shipvia = shipvia;
	}
	public Float getFreight() {
		return freight;
	}
	public void setFreight(Float freight) {
		this.freight = freight;
	}
	public String getShipname() {
		return shipname;
	}
	public void setShipname(String shipname) {
		this.shipname = shipname;
	}
	public String getShipaddress() {
		return shipaddress;
	}
	public void setShipaddress(String shipaddress) {
		this.shipaddress = shipaddress;
	}
	public String getShipcity() {
		return shipcity;
	}
	public void setShipcity(String shipcity) {
		this.shipcity = shipcity;
	}
	public String getShipregion() {
		return shipregion;
	}
	public void setShipregion(String shipregion) {
		this.shipregion = shipregion;
	}
	public String getShippostalcode() {
		return shippostalcode;
	}
	public void setShippostalcode(String shippostalcode) {
		this.shippostalcode = shippostalcode;
	}
	public String getShipcountry() {
		return shipcountry;
	}
	public void setShipcountry(String shipcountry) {
		this.shipcountry = shipcountry;
	}


	
	
	
	
	

}
