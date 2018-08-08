package agencevoyage.dao.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import agencevoyage.dao.IDaoVol;
import agencevoyage.model.vol.Vol;
import agencevoyage.Application;

public class DaoVolSQL implements IDaoVol {

	@Override
	public List<Vol> findAll() {

		List<Vol> liste = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = Application.getInstance().createConnection();
			ps = conn.prepareStatement("SELECT id, dt_depart, dt_arrivee, ouvert, nb_places, depart_id, arrivee_id FROM vol");

			rs = ps.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("id");
				java.util.Date dtDepart = rs.getDate("dt_depart");
				java.util.Date dtArrivee = rs.getDate("dt_arrivee");
				boolean ouvert = rs.getBoolean("ouvert");
				int nbPlace = rs.getInt("nb_places");
				Long depart = rs.getLong("depart_id");
				Long arrivee = rs.getLong("arrivee_id");

//				Vol obj = new Vol(id, dtDepart, dtArrivee, nbPlace, ouvert, depart, arrivee);

//				liste.add(obj);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return liste;
	}

	@Override
	public Vol find(Long id) {

		Vol obj = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = Application.getInstance().createConnection();
			ps = conn.prepareStatement("SELECT id, dt_depart, dt_arrivee, ouvert, nb_places, depart_id, arrivee_id FROM vol WHERE id = ?");

			ps.setLong(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {

				java.util.Date dtDepart = rs.getDate("dt_depart");
				java.util.Date dtArrivee = rs.getDate("dt_arrivee");
				boolean ouvert = rs.getBoolean("ouvert");
				int nbPlace = rs.getInt("nb_places");

				obj = new Vol(id, dtDepart, dtArrivee, nbPlace, ouvert);
			}

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	@Override
	public void save(Vol obj) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = Application.getInstance().createConnection();
			if (obj.getId() == null) {
				ps = conn.prepareStatement(
						"INSERT INTO vol (id, dt_depart, dt_arrivee, nb_places, ouvert, depart_id, arrivee_id) VALUES (nextval('vol_seq'),?,?,?,?,?,?)",
						Statement.RETURN_GENERATED_KEYS);

				java.sql.Date d1 = new java.sql.Date(obj.dtDepart.getTime());
				java.sql.Date d2 = new java.sql.Date(obj.dtArrivee.getTime());

				ps.setDate(1, d1);
				ps.setDate(2, d2);
				ps.setInt(3, obj.getNbPlace());
				ps.setBoolean(4, obj.isOuvert());
				ps.setLong(5, obj.getDepart().getId());
				ps.setLong(6, obj.getArrivee().getId());

				int rows = ps.executeUpdate();

				if (rows > 0) {
					ResultSet rs = ps.getGeneratedKeys();

					if (rs.next()) {
						Long id = rs.getLong(1);
						obj.setId(id);
					}
				}
			} else {
				ps = conn.prepareStatement(
						"UPDATE vol SET dt_depart = ?, dt_arrivee = ?,  nb_places = ?, ouvert = ?, depart_id = ?, arrivee_id = ? WHERE id = ?");

				java.sql.Date d1 = new java.sql.Date(obj.dtDepart.getTime());
				java.sql.Date d2 = new java.sql.Date(obj.dtArrivee.getTime());

				ps.setDate(1, d1);
				ps.setDate(2, d2);
				ps.setInt(3, obj.getNbPlace());
				ps.setBoolean(4, obj.isOuvert());
				ps.setLong(5, obj.getDepart().getId());
				ps.setLong(6, obj.getArrivee().getId());
				ps.setLong(7, obj.getId());

				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(Vol obj) {
		deleteById(obj.getId());
	}

	@Override
	public void deleteById(Long id) {

		PreparedStatement ps = null;

		try (Connection conn = Application.getInstance().createConnection()) {
			ps = conn.prepareStatement("DELETE FROM vol WHERE id = ?");

			ps.setLong(1, id);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}