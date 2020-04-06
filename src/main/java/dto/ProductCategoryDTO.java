package dto;

public class ProductCategoryDTO {
	
	private String productname;
	private String categoryname;
	public ProductCategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProductCategoryDTO [productname=" + productname + ", categoryname=" + categoryname + "]";
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	
	

}
