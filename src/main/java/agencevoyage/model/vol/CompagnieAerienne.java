package agencevoyage.model.vol;

import java.util.ArrayList;

public class CompagnieAerienne {
	private String nom;
	private ArrayList<CompagnieAerienneVol> vols = new ArrayList<>();

	public CompagnieAerienne() {

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<CompagnieAerienneVol> getVols() {
		return vols;
	}

	public void setVols(ArrayList<CompagnieAerienneVol> vols) {
		this.vols = vols;
	}

}
