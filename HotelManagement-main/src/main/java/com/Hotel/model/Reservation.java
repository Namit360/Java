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
public class Reservation {


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	
    public Long resid;
	@NotEmpty
    private String resname;
	@NotNull
    private int resadults;
	@NotNull
    private int reschild;
    @NotEmpty
    private String rescheckin;
    @NotEmpty
    private String rescheckout;
    @NotEmpty
    private String resroom;
    @NotEmpty
    private String resstatus;
	public Long getResid() {
		return resid;
	}
	public void setResid(Long resid) {
		this.resid = resid;
	}

	public String getResname() {
		return resname;
	}
	public void setResname(String resname) {
		this.resname = resname;
	}
	public int getResadults() {
		return resadults;
	}
	public void setResadults(int resadults) {
		this.resadults = resadults;
	}
	public int getReschild() {
		return reschild;
	}
	public void setReschild(int reschild) {
		this.reschild = reschild;
	}
	public String getRescheckin() {
		return rescheckin;
	}
	public void setRescheckin(String rescheckin) {
		this.rescheckin = rescheckin;
	}
	public String getRescheckout() {
		return rescheckout;
	}
	public void setRescheckout(String rescheckout) {
		this.rescheckout = rescheckout;
	}
	public String getResroom() {
		return resroom;
	}
	public void setResroom(String resroom) {
		this.resroom = resroom;
	}
	public String getResstatus() {
		return resstatus;
	}
	public void setResstatus(String resstatus) {
		this.resstatus = resstatus;
	}
    
    
	
    
}
