package entities;

import java.util.Arrays;
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

@Entity
@Table(name="categories")
public class Categories {
	
	@Id
	@Column(name="categoryid")
	private int categoryid;
	
	@Column(name="categoryname")
	private String categoryName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="picture")
	private Byte[] picture;
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
//    private List<Products> products;
	
	 
	
	 
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	    private List<Products> products;

	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	public List<Products> getProducts() {
		return products;
	}






	public int getCategory_id() {
		return categoryid;
	}

	public void setCategory_id(int category_id) {
		this.categoryid = category_id;
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
		return "Categories [category_id=" + categoryid + ", categoryName=" + categoryName + ", description="
				+ description + ", picture=" + Arrays.toString(picture) + "]";
	}

	
	
}
