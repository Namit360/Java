package com.Hotel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Room_Table")
public class Room {
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="roomno_generator")
    @SequenceGenerator(name = "roomno_generator",initialValue=101,allocationSize=1,sequenceName="roomno_seq")
	int roomno;
	String roomtype;
	String bedtype;
	String vacancy;
	double amount;
	public int getRoomno() {
		return roomno;
	}
	public void setRoomno(int roomNo) {
		this.roomno = roomNo;
	}
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomType) {
		this.roomtype = roomType;
	}
	public String getBedtype() {
		return bedtype;
	}
	public void setBedtype(String bedType) {
		this.bedtype = bedType;
	}
	public String getVacancy() {
		return vacancy;
	}
	public void setVacancy(String vacancy) {
		this.vacancy = vacancy;
	}

	
	
	
}

