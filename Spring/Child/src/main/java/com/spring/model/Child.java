package com.spring.model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Child 
{
	@Id
	public int childid;
	public String childname;
	public int parentid;
	public String parentname; 
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public int getChildid() {
		return childid;
	}
	public void setChildid(int childid) {
		this.childid = childid;
	}
	public String getChildname() {
		return childname;
	}
	public void setChildname(String childname) {
		this.childname = childname;
	}
}
