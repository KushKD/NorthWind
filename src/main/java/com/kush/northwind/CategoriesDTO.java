package com.kush.northwind;

public class CategoriesDTO {
	
	private String categoryName;
	private String description;
	
	
	public CategoriesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "CategoriesDTO [categoryName=" + categoryName + ", description=" + description + "]";
	}
	
	
	
	

}
