package com.patientManagement.beans;
import java.util.Date;

public class Patient {
     
	private int id;
	private String nom;
    private String prenom;
    private String addresse;
    private Date dateNaissance;
    private String numTel;
    private String sexe;
    
    
   
	public Patient(int id, String nom, String prenom, String addresse, Date dateNaissance, String  numTel) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.addresse = addresse;
		this.dateNaissance = dateNaissance;
		this.numTel = numTel;
	}
	
	

	public Patient(String nom, String prenom, String addresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.addresse = addresse;
	}



	public Patient(int id, String nom, String prenom, String addresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.addresse = addresse;
	}



	public Patient(int id, String nom, String prenom, String addresse,String sexe,String  numTel, Date dateNaissance) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.addresse = addresse;
		this.dateNaissance = dateNaissance;
		this.numTel = numTel;
		this.sexe = sexe;
	}



	public Patient(String nom, String prenom, String addresse, String sexe,String  numTel , Date dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.addresse = addresse;
		this.dateNaissance = dateNaissance;
		this.numTel = numTel;
		this.sexe = sexe;
	}



	public Patient(String nom, String prenom, String addresse, Date dateNaissance, String  numTel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.addresse = addresse;
		this.dateNaissance = dateNaissance;
		this.numTel = numTel;
	}


	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String  getNumTel() {
		return numTel;
	}
	public void setNumTel(String  numTel) {
		this.numTel = numTel;
	}
	

	public String getSexe() {
		return sexe;
	}



	public void setSexe(String sexe) {
		this.sexe = sexe;
	}



	@Override
	public String toString() {
		return "Patient [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", addresse=" + addresse
				+ ", dateNaissance=" + dateNaissance + ", numTel=" + numTel + ", sexe=" + sexe + "]";
	}



	
	
	
    
    
}
