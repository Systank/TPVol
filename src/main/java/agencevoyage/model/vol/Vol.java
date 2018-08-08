package agencevoyage.model.vol;

import java.util.ArrayList;
import java.util.Date;

import agencevoyage.model.reservation.Reservation;

public class Vol {
	public Long id;
	public Date dtDepart;
	public Date dtArrivee;
	public int nbPlace;
	public boolean ouvert;
	public ArrayList<Reservation> reservations = new ArrayList<>();
	public Aeroport depart;
	public Aeroport arrivee;
	public ArrayList<CompagnieAerienneVol> compagnieAeriennes = new ArrayList<>();
	public ArrayList<Escale> aeroports = new ArrayList<>();

	public Vol() {

	}

	public Vol(Date dtDepart, Date dtArrivee, int nbPlace, boolean ouvert) {
		super();
		this.dtDepart = dtDepart;
		this.dtArrivee = dtArrivee;
		this.nbPlace = nbPlace;
		this.ouvert = ouvert;
	}

	public Vol(Long id, Date dtDepart, Date dtArrivee, int nbPlace, boolean ouvert) {
		super();
		this.id = id;
		this.dtDepart = dtDepart;
		this.dtArrivee = dtArrivee;
		this.nbPlace = nbPlace;
		this.ouvert = ouvert;
	}

	public Vol(Long id, Date dtDepart, Date dtArrivee, int nbPlace, boolean ouvert, Aeroport depart, Aeroport arrivee) {
		super();
		this.id = id;
		this.dtDepart = dtDepart;
		this.dtArrivee = dtArrivee;
		this.nbPlace = nbPlace;
		this.ouvert = ouvert;
		this.depart = depart;
		this.arrivee = arrivee;
	}

	public Vol(Date dtDepart, Date dtArrivee, int nbPlace, boolean ouvert, Aeroport depart, Aeroport arrivee) {
		super();
		this.dtDepart = dtDepart;
		this.dtArrivee = dtArrivee;
		this.nbPlace = nbPlace;
		this.ouvert = ouvert;
		this.depart = depart;
		this.arrivee = arrivee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDtDepart() {
		return dtDepart;
	}

	public void setDtDepart(Date dtDepart) {
		this.dtDepart = dtDepart;
	}

	public Date getDtArrivee() {
		return dtArrivee;
	}

	public void setDtArrivee(Date dtArrivee) {
		this.dtArrivee = dtArrivee;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public boolean isOuvert() {
		return ouvert;
	}

	public void setOuvert(boolean ouvert) {
		this.ouvert = ouvert;
	}

	public Aeroport getDepart() {
		return depart;
	}

	public void setDepart(Aeroport depart) {
		this.depart = depart;
	}

	public Aeroport getArrivee() {
		return arrivee;
	}

	public void setArrivee(Aeroport arrivee) {
		this.arrivee = arrivee;
	}

	public ArrayList<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}

	public ArrayList<CompagnieAerienneVol> getCompagnieAeriennes() {
		return compagnieAeriennes;
	}

	public void setCompagnieAeriennes(ArrayList<CompagnieAerienneVol> compagnieAeriennes) {
		this.compagnieAeriennes = compagnieAeriennes;
	}

	public ArrayList<Escale> getAeroports() {
		return aeroports;
	}

	public void setAeroports(ArrayList<Escale> aeroports) {
		this.aeroports = aeroports;
	}

	public String toString() {
		return " Vol [id=" + id + ",dtDepart=" + dtDepart + ", dtArrivee=" + dtArrivee + ",nbPlace=" + nbPlace
				+ ", ouvert=" + ouvert + "]";
	}

}
