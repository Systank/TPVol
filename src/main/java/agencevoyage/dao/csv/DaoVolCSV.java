package agencevoyage.dao.csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import agencevoyage.dao.IDaoVol;
import agencevoyage.model.vol.Vol;

public class DaoVolCSV implements IDaoVol {

	private final String chemin;

	public DaoVolCSV(String chemin) {
		super();
		this.chemin = chemin;
	}

	@Override
	public List<Vol> findAll() {
		return read();
	}

	@Override
	public Vol find(Long id) {
		for (Vol vol : read()) {
			if (vol.getId().equals(id))
				return vol;
		}
		return null;
	}

	@Override
	public void save(Vol obj) {
		List<Vol> liste = read();
		if (obj.getId() == null) {
			Long max = 0L;
			for (Vol vol : liste) {
				if (max < vol.getId()) {
					max = vol.getId();
				}
			}
			obj.setId(++max);
			liste.add(obj);

		} else {
			int idx;

			for (idx = 0; idx < liste.size(); idx++) {
				if (liste.get(idx).getId().equals(obj.getId())) {
					break;
				}
			}
			liste.set(idx, obj);
		}
		write(liste);
	}

	@Override
	public void delete(Vol obj) {
		deleteById(obj.getId());
	}

	@Override
	public void deleteById(Long id) {
		List<Vol> liste = read();

		int idx;

		for (idx = 0; idx < liste.size(); idx++) {
			if (liste.get(idx).getId().equals(id)) {
				break;
			}
		}
		liste.remove(idx);
		write(liste);
	}

	private List<Vol> read() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Vol> liste = new ArrayList<>();
		
		
		try {
			List<String> lignes = Files.readAllLines(Paths.get(chemin));
			
			
			for (String ligne : lignes) {
				String[] items = ligne.split(";");
				Long id = Long.valueOf(items[0]);
				Date dtDepart = sdf.parse(items[1]);
				Date dtArrivee = sdf.parse(items[2]);
				int nbPlace = Integer.valueOf(items[3]);
				boolean ouvert = Boolean.valueOf(items[4]);
				
				

				Vol obj = new Vol(id, dtDepart, dtArrivee, nbPlace, ouvert);
				

				liste.add(obj);
				
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return liste;
	}

	private void write(List<Vol> liste) {

		StringBuilder sb = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		for (Vol obj : liste) {
			sb.append(obj.getId());
			sb.append(";");
			sb.append(sdf.format(obj.getDtDepart()));
			sb.append(";");
			sb.append(sdf.format(obj.getDtArrivee()));
			sb.append(";");
			sb.append(obj.getNbPlace());
			sb.append(";");
			sb.append(obj.isOuvert());
			sb.append("\n");

		}
		String lignes = sb.toString();
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(chemin);
			bw = new BufferedWriter(fw);
			bw.write(lignes);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
