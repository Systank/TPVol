package agencevoyage.model.reservation;

public class Particulier extends Client {
	
	private String prenom;
	private String civilite;
	
	public Particulier() {
		
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	
	

}
