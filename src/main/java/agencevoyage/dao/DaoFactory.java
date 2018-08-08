package agencevoyage.dao;

import agencevoyage.dao.SQL.DaoAeroportSQL;
import agencevoyage.dao.SQL.DaoVolSQL;

public class DaoFactory {

	private static IDaoVol daoVol = null;
	private static IDaoAeroport daoAeroport = null;

	public static IDaoVol getDaoVol() {
		if (daoVol == null) {
			daoVol = new DaoVolSQL();
		}

		return daoVol;
	}

	public static IDaoAeroport getDaoAeroport() {
		if (daoAeroport == null) {
			daoAeroport = new DaoAeroportSQL();
		}

		return daoAeroport;
	}
}
