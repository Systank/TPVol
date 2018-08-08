package agencevoyage.model.vol;

import java.util.Date;

public class Escale {

	private Date hDepart;
	private Date hArrivee;
	private Vol vol;
	private Aeroport aeroport;

	public Escale() {

	}

	public Date gethDepart() {
		return hDepart;
	}

	public void sethDepart(Date hDepart) {
		this.hDepart = hDepart;
	}

	public Date gethArrivee() {
		return hArrivee;
	}

	public void sethArrivee(Date hArrivee) {
		this.hArrivee = hArrivee;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	public Aeroport getAeroport() {
		return aeroport;
	}

	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}

}
