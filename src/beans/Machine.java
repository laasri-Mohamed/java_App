package beans;

import java.util.Date;

public class Machine {

	private int id;
	private String reference;
	private String marque;
	private Date dateAchat;
	private double prix;
	private Employe employe; 
	
	
	public Machine(int id, String reference, String marque, Date dateAchat, double prix, Employe employe) {
		super();
		this.id = id;
		this.reference = reference;
		this.marque = marque;
		this.dateAchat = dateAchat;
		this.prix = prix;
		this.employe = employe;
	}
	
	
	public Machine(String reference, String marque, Date dateAchat, double prix, Employe employe) {
		super();
		this.reference = reference;
		this.marque = marque;
		this.dateAchat = dateAchat;
		this.prix = prix;
		this.employe = employe;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public Date getDateAchat() {
		return dateAchat;
	}
	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}


	public Employe getEmploye() {
		return employe;
	}


	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	
}
