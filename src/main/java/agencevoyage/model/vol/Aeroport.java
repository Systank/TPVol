package agencevoyage.model.vol;

import java.util.ArrayList;

public class Aeroport {
	public Long id;
	public String code;
	public ArrayList<Ville> villes = new ArrayList<>();
	public ArrayList<Escale> vols = new ArrayList<>();

	public Aeroport() {

	}
	

	public Aeroport(String code) {
		super();
		this.code = code;
	}


	public Aeroport(Long id, String code) {
		super();
		this.id = id;
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ArrayList<Ville> getVilles() {
		return villes;
	}

	public void setVilles(ArrayList<Ville> villes) {
		this.villes = villes;
	}

	public ArrayList<Escale> getVols() {
		return vols;
	}

	public void setVols(ArrayList<Escale> vols) {
		this.vols = vols;
	}

}
