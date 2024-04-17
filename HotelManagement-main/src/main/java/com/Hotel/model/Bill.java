package com.Hotel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
public class Bill {


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long billid;
	@NotEmpty
    private String cusname;
	@NotNull
    private int room;
	@NotNull
    private Double amount;
	@NotNull
    private Double tax;
	@NotNull
    private Double totalamount;
	@NotNull
    private String status;
    
	public Long getBillid() {
		return billid;
	}
	public void setBillid(Long billid) {
		this.billid = billid;
	}
	public String getCusname() {
		return cusname;
	}
	public void setCusname(String cusname) {
		this.cusname = cusname;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	public Double getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(Double totalamount) {
		this.totalamount = totalamount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Bill() {}
	public Bill(Long billid, String cusname, int room, Double amount, Double tax, Double totalamount, String status) {
		super();
		this.billid = billid;
		this.cusname = cusname;
		this.room = room;
		this.amount = amount;
		this.tax = tax;
		this.totalamount = totalamount;
		this.status = status;
	}
	
  
}
