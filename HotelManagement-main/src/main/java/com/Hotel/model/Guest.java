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
public class Guest {


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long guestid;
	@NotEmpty
    private String guestname;
    private Long guestphone;
    @NotEmpty
    private String guestemail;
    @NotEmpty
    private String guestgender;
    @NotEmpty
    private String guestcompany;
    @NotEmpty
    private String guestaddress;
    @NotEmpty
    private String guestroom;
    @NotEmpty
    private String guestcheckin;
    @NotEmpty
    private String guestcheckout;
    @NotNull
    private Double guestamount;
	public Long getGuestid() {
		return guestid;
	}
	public void setGuestid(Long guestid) {
		this.guestid = guestid;
	}
	public String getGuestname() {
		return guestname;
	}
	public void setGuestname(String guestname) {
		this.guestname = guestname;
	}
	public Long getGuestphone() {
		return guestphone;
	}
	public void setGuestphone(Long guestphone) {
		this.guestphone = guestphone;
	}
	public String getGuestemail() {
		return guestemail;
	}
	public void setGuestemail(String guestemail) {
		this.guestemail = guestemail;
	}
	public String getGuestgender() {
		return guestgender;
	}
	public void setGuestgender(String guestgender) {
		this.guestgender = guestgender;
	}
	public String getGuestcompany() {
		return guestcompany;
	}
	public void setGuestcompany(String guestcompany) {
		this.guestcompany = guestcompany;
	}
	public String getGuestaddress() {
		return guestaddress;
	}
	public void setGuestaddress(String guestaddress) {
		this.guestaddress = guestaddress;
	}
	public String getGuestroom() {
		return guestroom;
	}
	public void setGuestroom(String guestroom) {
		this.guestroom = guestroom;
	}
	public String getGuestcheckin() {
		return guestcheckin;
	}
	public void setGuestcheckin(String guestcheckin) {
		this.guestcheckin = guestcheckin;
	}
	public String getGuestcheckout() {
		return guestcheckout;
	}
	public void setGuestcheckout(String guestcheckout) {
		this.guestcheckout = guestcheckout;
	}
	public Double getGuestamount() {
		return guestamount;
	}
	public void setGuestamount(Double guestamount) {
		this.guestamount = guestamount;
	}
	public Guest() {}
	public Guest(Long guestid, String guestname, Long guestphone, String guestemail, String guestgender,
			String guestcompany, String guestaddress, String guestroom, String guestcheckin, String guestcheckout,
			Double guestamount) {
		super();
		this.guestid = guestid;
		this.guestname = guestname;
		this.guestphone = guestphone;
		this.guestemail = guestemail;
		this.guestgender = guestgender;
		this.guestcompany = guestcompany;
		this.guestaddress = guestaddress;
		this.guestroom = guestroom;
		this.guestcheckin = guestcheckin;
		this.guestcheckout = guestcheckout;
		this.guestamount = guestamount;
	}

	
    
}
