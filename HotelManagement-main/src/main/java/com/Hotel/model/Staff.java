package com.Hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Staff_Details")
public class Staff {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int staffId;
	@Column(name="Staff_Name")
	@NotEmpty
	String staffName;
	@Column(name="Staff_Address")
	@NotEmpty
	String staffAddress;
	@Column(name="Email")
	@NotEmpty
	String email;
	@Column(name="Age")
	@NotNull
	@Min(21)
	int age;
	@Column(name="Salary")
	@NotNull
	long salary;
	
	 
	public Staff() {}
	
	public Staff(int staffId, String staffName, String staffAddress, int age, Long salary, String email) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffAddress = staffAddress;
		this.age = age;
		this.salary = salary;
		this.email = email;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffAddress() {
		return staffAddress;
	}

	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	

}
