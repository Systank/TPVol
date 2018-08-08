package agencevoyage.model.vol;

import java.util.ArrayList;

public class Ville {

	private String nom;
	private String codePostal;
	private String pays;
	private ArrayList<Aeroport> aeroports = new ArrayList<>();
	
	public Ville() {
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public ArrayList<Aeroport> getAeroports() {
		return aeroports;
	}

	public void setAeroports(ArrayList<Aeroport> aeroports) {
		this.aeroports = aeroports;
	}

}
