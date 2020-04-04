package entities;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Categories {
	
	@Id
	@Column(name="categoryid")
	private int category_id;
	
	@Column(name="categoryname")
	private String categoryName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="picture")
	private Byte[] picture;

	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
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

	public Byte[] getPicture() {
		return picture;
	}

	public void setPicture(Byte[] picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Categories [category_id=" + category_id + ", categoryName=" + categoryName + ", description="
				+ description + ", picture=" + Arrays.toString(picture) + "]";
	}

	
	
}
