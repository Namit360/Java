package com.spring.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Parent 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "parent_id")
	public int parentid;
	@Column(name = "parent_name")
	public String parentname;
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public String getParentname() {
		return parentname;
	}
	public void setParentname(String parentname) {
		this.parentname = parentname;
	}
}
