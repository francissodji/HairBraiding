package com.hairbraiding.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Profil")
public class Profil {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idprofil;
	
	@Column(name="titleprofil")
	private String titleprofil;
	
	
	public Profil() {}
	
	
	public Profil(String titleprofil) {
		super();
		this.titleprofil = titleprofil;
	}


	public int getIdprofil() {
		return idprofil;
	}


	public void setIdprofil(Integer idprofil) {
		this.idprofil = idprofil;
	}


	public String getTitleprofil() {
		return titleprofil;
	}


	public void setTitleprofil(String titleprofil) {
		this.titleprofil = titleprofil;
	}


	@Override
	public String toString() {
		return "Profil [idprofil=" + idprofil + ", titleprofil=" + titleprofil + "]";
	}
	
}

