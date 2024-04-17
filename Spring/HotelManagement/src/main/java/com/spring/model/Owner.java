package com.spring.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="depts")
public class Owner
{
	@Id
	public int deptid;
	public String deptname;
	public int managerid;
	public String managername;
	public int staffavail;
	
	Owner(){}
	
	public Owner(int deptid, String deptname, int managerid, String managername, int staffavail) {
		super();
		this.deptid = deptid;
		this.deptname = deptname;
		this.managerid = managerid;
		this.managername = managername;
		this.staffavail = staffavail;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public int getManagerid() {
		return managerid;
	}

	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	public int getStaffavail() {
		return staffavail;
	}

	public void setStaffavail(int staffavail) {
		this.staffavail = staffavail;
	}	
}