package agencevoyage.model.reservation;

import agencevoyage.model.vol.Vol;

public class Reservation {

	private String code;
	private boolean confirmee;
	private boolean annulee;
	private Vol vol;
	private Passager passager;
	private Client client;

	
	public Reservation () {
		
	}
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isConfirmee() {
		return confirmee;
	}

	public void setConfirmee(boolean confirmee) {
		this.confirmee = confirmee;
	}

	public boolean isAnnulee() {
		return annulee;
		
	
	}

	public void setAnnulee(boolean annulee) {
		this.annulee = annulee;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	public Passager getPassager() {
		return passager;
	}

	public void setPassager(Passager passager) {
		this.passager = passager;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
}
