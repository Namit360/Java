package com.spring.model;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Productdetails")
public class Product 
{
	@Id
	@Column(name="Product_Id")
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	public int productid;
	
	@Column(name="Product_Name")
	public String productname;
	
	@Column(name="Product_Cost")
	public int productcost;
	
	@Embedded
	Tags tagid;

	public Tags getTagid() {
		return tagid;
	}

	public void setTagid(Tags tagid) {
		this.tagid = tagid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getProductcost() {
		return productcost;
	}

	public void setProductcost(int productcost) {
		this.productcost = productcost;
	}
}