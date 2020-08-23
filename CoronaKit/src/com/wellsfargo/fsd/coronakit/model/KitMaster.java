package com.wellsfargo.fsd.coronakit.model;

public class KitMaster {

	@Override
	public String toString() {
		return "KitMaster [uname=" + uname + ", phno=" + phno + ", email=" + email + "]";
	}
	private String uname;
	private String phno;
	private String email;
	private String address;
	private String State;
	private String zip;
	
	public KitMaster(String uname, String phno, String email, String address, String state, String zip) {
		super();
		this.uname = uname;
		this.phno = phno;
		this.email = email;
		this.address = address;
		State = state;
		this.zip = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public KitMaster(String uname, String phno, String email) {
		super();
		this.uname = uname;
		this.phno = phno;
		this.email = email;
	}
	public KitMaster() {
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
