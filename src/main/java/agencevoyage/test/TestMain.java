package agencevoyage.test;

import java.util.Date;

import agencevoyage.model.reservation.Adresse;
import agencevoyage.model.reservation.Particulier;
import agencevoyage.model.reservation.Passager;
import agencevoyage.model.reservation.Reservation;
import agencevoyage.model.vol.Aeroport;
import agencevoyage.model.vol.CompagnieAerienne;
import agencevoyage.model.vol.CompagnieAerienneVol;
import agencevoyage.model.vol.Escale;
import agencevoyage.model.vol.Ville;
import agencevoyage.model.vol.Vol;

public class TestMain {

	public static void main(String[] args) {

		Ville ville1 = new Ville();
		ville1.setNom("Agen");
		ville1.setCodePostal("47000");
		ville1.setPays("France");

		Ville ville2 = new Ville();
		ville2.setNom("Roissy-En-France");
		ville2.setCodePostal("95700");
		ville2.setPays("France");

		Ville ville3 = new Ville();
		ville3.setNom("Merignac");
		ville3.setCodePostal("33700");
		ville3.setPays("France");

		Aeroport aeroport1 = new Aeroport();
		aeroport1.setCode("AGF");

		Aeroport aeroport2 = new Aeroport();
		aeroport2.setCode("CDG");

		Aeroport aeroport3 = new Aeroport();
		aeroport3.setCode("BOD");

		Escale escale1 = new Escale();
		Date dateEsc1 = new Date(2018, 07, 26, 14, 17);
		escale1.sethDepart(dateEsc1);
		Date dateEsc2 = new Date(2018, 07, 26, 12, 57);
		escale1.sethArrivee(dateEsc2);
		escale1.setAeroport(aeroport2);
		
		aeroport1.getVilles().add(ville1);
		ville1.getAeroports().add(aeroport1);
				
		aeroport2.getVilles().add(ville2);
		ville2.getAeroports().add(aeroport2);
		
		aeroport3.getVilles().add(ville3);
		ville3.getAeroports().add(aeroport3);
		
		aeroport2.getVols().add(escale1);
		
		CompagnieAerienne compagnie1 = new CompagnieAerienne();
		compagnie1.setNom("Rayanair");

		CompagnieAerienneVol caVol1 = new CompagnieAerienneVol();
		caVol1.setNumero("AS123");
		caVol1.setCompagnieAerienne(compagnie1);
		
		compagnie1.getVols().add(caVol1);

		Vol vol1 = new Vol();
		vol1.setDepart(aeroport1);
		vol1.setArrivee(aeroport3);
		Date dateDpt1 = new Date(2018, 6, 26, 10, 24);
		vol1.setDtDepart(dateDpt1);
		Date dateArrivee1 = new Date(2018, 6, 26, 16, 25);
		vol1.setDtArrivee(dateArrivee1);
		vol1.setNbPlace(250);
		vol1.setOuvert(true);
		vol1.getAeroports().add(escale1);
		vol1.getCompagnieAeriennes().add(caVol1);
		
		caVol1.setVol(vol1);
		
		Adresse adresse1 = new Adresse();	
		
		adresse1.setRue("rue Ausone");
		adresse1.setCodePostal(" 33520");
		adresse1.setVille(" Bruges");
		adresse1.setPays(" France");
		
		Adresse adresse2 = new Adresse();	
		
		adresse2.setRue("Avenue Charles de Gaulle");
		adresse2.setCodePostal(" 33000");
		adresse2.setVille(" Bordeaux");
		adresse2.setPays(" France");
		
		Particulier particulier1 = new Particulier();
		
		particulier1.setCivilite("M");
		particulier1.setNom("Ieud");
		particulier1.setPrenom("Nob");
		particulier1.setAdresse(adresse1);
		
		Passager passager1 =  new Passager();
		
		passager1.setNom("Ieud");
		passager1.setPrenom("Nob");
		Date dtPassager1 = new Date(1993,11,23);
		passager1.setDtNaissance(dtPassager1);
		passager1.setPieceIdentite("tetedemort");
		passager1.setAdr(adresse1);
		
		Reservation reservation1 = new Reservation ();
		reservation1.setAnnulee(false);
		reservation1.setConfirmee(true);
		reservation1.setCode("yahou");
		reservation1.setPassager(passager1);
		reservation1.setClient(particulier1);
		
		particulier1.getReservations().add(reservation1);
		passager1.setReservation(reservation1);
		vol1.getReservations().add(reservation1);
		
	
	}
}
