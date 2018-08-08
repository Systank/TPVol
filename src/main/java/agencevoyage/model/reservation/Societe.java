package agencevoyage.model.reservation;

public class Societe extends Client {

	private String siret;
	private String formejuridique;
	
	public Societe() {
		
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getFormejuridique() {
		return formejuridique;
	}

	public void setFormejuridique(String formejuridique) {
		this.formejuridique = formejuridique;
	}
	
	
}
