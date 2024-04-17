package com.Hotel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Department {


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long deptid;
    private String deptname;
    private String deptstatus;
    private int staff;
	public Long getDeptid() {
		return deptid;
	}
	public void setDeptid(Long deptid) {
		this.deptid = deptid;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getDeptstatus() {
		return deptstatus;
	}
	public void setDeptstatus(String deptstatus) {
		this.deptstatus = deptstatus;
	}
	public int getStaff() {
		return staff;
	}
	public void setStaff(int staff) {
		this.staff = staff;
	}
	
    
	
}
