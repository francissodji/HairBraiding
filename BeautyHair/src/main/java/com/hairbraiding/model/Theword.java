package com.hairbraiding.model;

import java.util.Date;

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
@Table(name="Theword")
public class Theword {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idpassword;

	@Column
	private Integer numconnection;
	
	@Column
	private String password;
	
	@Column
	private Date datebeginpw;
	
	@Column
	private Date dateendpw;
	
	@ManyToOne()
	@JoinColumn(name="iduser", foreignKey=@ForeignKey(name="fk_theword_users"))
	private Users iduser;

	public Theword() {}


	public Theword(Integer numconnection, String password, Date datebeginpw, Date dateendpw, Users iduser) {
		super();
		this.numconnection = numconnection;
		this.password = password;
		this.datebeginpw = datebeginpw;
		this.dateendpw = dateendpw;
		this.iduser = iduser;
	}


	public Integer getIdpassword() {
		return idpassword;
	}


	public void setIdpassword(Integer idpassword) {
		this.idpassword = idpassword;
	}


	public Integer getNumconnection() {
		return numconnection;
	}


	public void setNumconnection(Integer numconnection) {
		this.numconnection = numconnection;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getDatebeginpw() {
		return datebeginpw;
	}


	public void setDatebeginpw(Date datebeginpw) {
		this.datebeginpw = datebeginpw;
	}


	public Date getDateendpw() {
		return dateendpw;
	}


	public void setDateendpw(Date dateendpw) {
		this.dateendpw = dateendpw;
	}


	public Users getIduser() {
		return iduser;
	}


	public void setIduser(Users iduser) {
		this.iduser = iduser;
	}


	@Override
	public String toString() {
		return "Theword [idpassword=" + idpassword + ", numconnection=" + numconnection + ", password=" + password
				+ ", datebeginpw=" + datebeginpw + ", dateendpw=" + dateendpw + ", iduser=" + iduser + "]";
	}
	
}
