package com.spring;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Admin 
{
	@Id
	private int adminId;
	private String adminName;
	private String admindept;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdmindept() {
		return admindept;
	}
	public void setAdmindept(String admindept) {
		this.admindept = admindept;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", admindept=" + admindept + "]";
	}
}