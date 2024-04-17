package com.spring.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="depts")
public class Owner
{
	@Id
	public int deptId;
	public String deptName;
	public int managerId;
	public String managerName;
	public int staffAvail;
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public int getStaffAvail() {
		return staffAvail;
	}
	public void setStaffAvail(int staffAvail) {
		this.staffAvail = staffAvail;
	}
}