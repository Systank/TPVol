package agencevoyage.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import agencevoyage.dao.DaoFactory;
import agencevoyage.dao.IDaoAeroport;
import agencevoyage.dao.IDaoVol;
import agencevoyage.model.vol.Aeroport;
import agencevoyage.model.vol.Vol;

public class TestVolCSV {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		IDaoVol daoVol = DaoFactory.getDaoVol();
		IDaoAeroport daoAeroport = DaoFactory.getDaoAeroport();

		Vol factice = null;
		try {
			factice = new Vol(sdf.parse("16/07/2018"), sdf.parse("17/07/2018"), 250, true);
			daoVol.save(factice);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		Vol facticeCopy = daoVol.find(factice.getId());

		facticeCopy.setNbPlace(245);
		facticeCopy.setOuvert(false);

		daoVol.save(facticeCopy);

//		daoVol.deleteById(factice.getId());
		
		
//		Aeroport aerodpt = null;
//		aerodpt = new Aeroport("YUL");
//		daoAeroport.save(aerodpt);
//		
//		Aeroport aeroarv = null;
//		aeroarv = new Aeroport("CDG");
//		daoAeroport.save(aeroarv);
		
		Vol facticeComplet = daoVol.find(facticeCopy.getId());
		
		facticeComplet.setDepart(daoAeroport.find(29L));;
		facticeComplet.setArrivee(daoAeroport.find(30L));
		
		daoVol.save(facticeCopy);
	}
	
}
