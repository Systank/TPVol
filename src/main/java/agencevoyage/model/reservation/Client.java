package agencevoyage.model.reservation;

import java.util.ArrayList;

public abstract class Client {
	
	private String nom;
	private ArrayList<Reservation>reservations = new  ArrayList<Reservation>();
	private Adresse adresse;
	

	public Client() {
		
	}
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public ArrayList<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}



}
