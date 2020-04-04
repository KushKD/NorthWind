package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Products {
	
	@Id
	@Column(name="productid")
	private Integer productid;
	
	@Column(name="productname")
	private String productname;
	
	@Column(name="supplierid")
	private Integer supplierid;
	
	@Column(name="categoryid")
	private Integer categoryid;
	
	@Column(name="quantityperunit")
	private String quantityperunit;
	
	@Column(name="unitprice")
	private Float unitprice;
	
	@Column(name="unitsinstock")
	private Integer unitsinstock;
	
	@Column(name="unitsonorder")
	private Integer unitsonorder ;
	
	@Column(name="reorderlevel")
	private Integer reorderlevel ;
	
	@Column(name="discontinued")
	private Integer discontinued ;

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Integer getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(Integer supplierid) {
		this.supplierid = supplierid;
	}

	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public String getQuantityperunit() {
		return quantityperunit;
	}

	public void setQuantityperunit(String quantityperunit) {
		this.quantityperunit = quantityperunit;
	}

	public Float getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Float unitprice) {
		this.unitprice = unitprice;
	}

	public Integer getUnitsinstock() {
		return unitsinstock;
	}

	public void setUnitsinstock(Integer unitsinstock) {
		this.unitsinstock = unitsinstock;
	}

	public Integer getUnitsonorder() {
		return unitsonorder;
	}

	public void setUnitsonorder(Integer unitsonorder) {
		this.unitsonorder = unitsonorder;
	}

	public Integer getReorderlevel() {
		return reorderlevel;
	}

	public void setReorderlevel(Integer reorderlevel) {
		this.reorderlevel = reorderlevel;
	}

	public Integer getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(Integer discontinued) {
		this.discontinued = discontinued;
	}

	@Override
	public String toString() {
		return "Products [productid=" + productid + ", productname=" + productname + ", supplierid=" + supplierid
				+ ", categoryid=" + categoryid + ", quantityperunit=" + quantityperunit + ", unitprice=" + unitprice
				+ ", unitsinstock=" + unitsinstock + ", unitsonorder=" + unitsonorder + ", reorderlevel=" + reorderlevel
				+ ", discontinued=" + discontinued + "]";
	}
	
	
	
	

}