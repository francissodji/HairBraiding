package com.hairbraiding.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Braider")
public class Braider {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idbraider;
	
	@Column(name = "fnamebraider", length=100)
	private String fnamebraider;
	
	@Column(name = "mnamebraider",length=50)
	private String mnamebraider;
	
	@Column(name = "lnamebraider", length=100)
	private String lnamebraider;
	
	@Column(name = "phonebraider", length=14)
	private String phonebraider;
	
	@Column(name = "celbraider", length=14)
	private String celbraider;
	
	@Column(name = "streetbraider", length=100)
	private String streetbraider;
	
	@Column(name = "countybraider", length=50)
	private String countybraider;
	
	@Column(name = "zipcodebraider", length=10)
	private String zipcodebraider;
	
	@Column(name = "statebraider", length=2)
	private String statebraider;
	
	@Column(name = "emailbraider", length=100)
	private String emailbraider;
	
	@Column(name = "ownerstatus")
	private boolean ownerstatus;
	
	
	@Column(name = "isbraideruseregister")
	private boolean isbraideruseregister;
	
	
	@Column(name = "idregisterbraider")
	private int idregisterbraider;
	
	
	@Column(name = "displayregister")
	private boolean displayregister;
	
	
	@ManyToOne()
	@JoinColumn(name="iduser", foreignKey=@ForeignKey(name="fk_braider_users"))
	private Users iduserbraider;
	
	
	public Braider() {}


	public Braider(String fnamebraider, String mnamebraider, String lnamebraider, String phonebraider,
			String celbraider, String streetbraider, String countybraider, String zipcodebraider, String statebraider,
			String emailbraider, boolean ownerstatus, boolean isbraideruseregister, int idregisterbraider,
			boolean displayregister, Users iduserbraider) {
		super();
		this.fnamebraider = fnamebraider;
		this.mnamebraider = mnamebraider;
		this.lnamebraider = lnamebraider;
		this.phonebraider = phonebraider;
		this.celbraider = celbraider;
		this.streetbraider = streetbraider;
		this.countybraider = countybraider;
		this.zipcodebraider = zipcodebraider;
		this.statebraider = statebraider;
		this.emailbraider = emailbraider;
		this.ownerstatus = ownerstatus;
		this.isbraideruseregister = isbraideruseregister;
		this.idregisterbraider = idregisterbraider;
		this.displayregister = displayregister;
		this.iduserbraider = iduserbraider;
	}


	public long getIdbraider() {
		return idbraider;
	}


	public void setIdbraider(long idbraider) {
		this.idbraider = idbraider;
	}


	public String getFnamebraider() {
		return fnamebraider;
	}


	public void setFnamebraider(String fnamebraider) {
		this.fnamebraider = fnamebraider;
	}


	public String getMnamebraider() {
		return mnamebraider;
	}


	public void setMnamebraider(String mnamebraider) {
		this.mnamebraider = mnamebraider;
	}


	public String getLnamebraider() {
		return lnamebraider;
	}


	public void setLnamebraider(String lnamebraider) {
		this.lnamebraider = lnamebraider;
	}


	public String getPhonebraider() {
		return phonebraider;
	}


	public void setPhonebraider(String phonebraider) {
		this.phonebraider = phonebraider;
	}


	public String getCelbraider() {
		return celbraider;
	}


	public void setCelbraider(String celbraider) {
		this.celbraider = celbraider;
	}


	public String getStreetbraider() {
		return streetbraider;
	}


	public void setStreetbraider(String streetbraider) {
		this.streetbraider = streetbraider;
	}


	public String getCountybraider() {
		return countybraider;
	}


	public void setCountybraider(String countybraider) {
		this.countybraider = countybraider;
	}


	public String getZipcodebraider() {
		return zipcodebraider;
	}


	public void setZipcodebraider(String zipcodebraider) {
		this.zipcodebraider = zipcodebraider;
	}


	public String getStatebraider() {
		return statebraider;
	}


	public void setStatebraider(String statebraider) {
		this.statebraider = statebraider;
	}


	public String getEmailbraider() {
		return emailbraider;
	}


	public void setEmailbraider(String emailbraider) {
		this.emailbraider = emailbraider;
	}


	public boolean isOwnerstatus() {
		return ownerstatus;
	}


	public void setOwnerstatus(boolean ownerstatus) {
		this.ownerstatus = ownerstatus;
	}


	public boolean isIsbraideruseregister() {
		return isbraideruseregister;
	}


	public void setIsbraideruseregister(boolean isbraideruseregister) {
		this.isbraideruseregister = isbraideruseregister;
	}


	public int getIdregisterbraider() {
		return idregisterbraider;
	}


	public void setIdregisterbraider(int idregisterbraider) {
		this.idregisterbraider = idregisterbraider;
	}


	public boolean isDisplayregister() {
		return displayregister;
	}


	public void setDisplayregister(boolean displayregister) {
		this.displayregister = displayregister;
	}


	public Users getIduserbraider() {
		return iduserbraider;
	}


	public void setIduserbraider(Users iduserbraider) {
		this.iduserbraider = iduserbraider;
	}


	@Override
	public String toString() {
		return "Braider [idbraider=" + idbraider + ", fnamebraider=" + fnamebraider + ", mnamebraider=" + mnamebraider
				+ ", lnamebraider=" + lnamebraider + ", phonebraider=" + phonebraider + ", celbraider=" + celbraider
				+ ", streetbraider=" + streetbraider + ", countybraider=" + countybraider + ", zipcodebraider="
				+ zipcodebraider + ", statebraider=" + statebraider + ", emailbraider=" + emailbraider
				+ ", ownerstatus=" + ownerstatus + ", isbraideruseregister=" + isbraideruseregister
				+ ", idregisterbraider=" + idregisterbraider + ", displayregister=" + displayregister
				+ ", iduserbraider=" + iduserbraider + "]";
	}

	
}


