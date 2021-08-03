package com.hairbraiding.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

@Entity
@Table(name="Users")
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer iduser;
	
	@Column(name="username")
	private String Username;
	
	@Column(name="dateuserexpire")
	private Date Dateuserexpire;
	
	@Column(name="connectstate")
	private boolean Connectstate;
	

	@ManyToOne()
	@JoinColumn(name="idprofil", foreignKey=@ForeignKey(name="fk_users_profil"))
	private Profil idprofil;
	
	
	public Users() {}


	public Users(String username, Date dateuserexpire, boolean connectstate, Profil idprofil) {
		super();
		Username = username;
		Dateuserexpire = dateuserexpire;
		Connectstate = connectstate;
		this.idprofil = idprofil;
	}


	public int getIduser() {
		return iduser;
	}


	public void setIduser(Integer iduser) {
		this.iduser = iduser;
	}


	public String getUsername() {
		return Username;
	}


	public void setUsername(String username) {
		Username = username;
	}


	public Date getDateuserexpire() {
		return Dateuserexpire;
	}


	public void setDateuserexpire(Date dateuserexpire) {
		Dateuserexpire = dateuserexpire;
	}


	public boolean isConnectstate() {
		return Connectstate;
	}


	public void setConnectstate(boolean connectstate) {
		Connectstate = connectstate;
	}


	public Profil getIdprofil() {
		return idprofil;
	}


	public void setIdprofil(Profil idprofil) {
		this.idprofil = idprofil;
	}


	@Override
	public String toString() {
		return "Users [iduser=" + iduser + ", Username=" + Username + ", Dateuserexpire=" + Dateuserexpire
				+ ", Connectstate=" + Connectstate + ", idprofil=" + idprofil + "]";
	}
	

	
}



