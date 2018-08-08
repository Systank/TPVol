package agencevoyage.dao.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import agencevoyage.Application;
import agencevoyage.dao.IDaoAeroport;
import agencevoyage.model.vol.Aeroport;

public class DaoAeroportSQL implements IDaoAeroport {

	@Override
	public List<Aeroport> findAll() {
		List<Aeroport> liste = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = Application.getInstance().createConnection();
			ps = conn.prepareStatement("SELECT id, code FROM aeroport");

			rs = ps.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("id");
				String code = rs.getString("code");

				Aeroport obj = new Aeroport(id, code);

				liste.add(obj);
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
	public Aeroport find(Long id) {

		Aeroport obj = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = Application.getInstance().createConnection();
			ps = conn.prepareStatement("SELECT id, code FROM aeroport WHERE id = ?");

			ps.setLong(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {

				String code = rs.getString("code");

				obj = new Aeroport(id, code);
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
	public void save(Aeroport obj) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = Application.getInstance().createConnection();
			if (obj.getId() == null) {
				ps = conn.prepareStatement("INSERT INTO aeroport (id, code) VALUES (nextval('vol_seq'),?)",
						Statement.RETURN_GENERATED_KEYS);

				ps.setString(1, obj.getCode());

				int rows = ps.executeUpdate();

				if (rows > 0) {
					ResultSet rs = ps.getGeneratedKeys();

					if (rs.next()) {
						Long id = rs.getLong(1);
						obj.setId(id);
					}
				}
			} else {
				ps = conn.prepareStatement("UPDATE aeroport SET code = ? WHERE id = ?");

				ps.setString(1, "code");
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
	public void delete(Aeroport obj) {
		deleteById(obj.getId());
	}

	@Override
	public void deleteById(Long id) {
		PreparedStatement ps = null;

		try (Connection conn = Application.getInstance().createConnection()) {
			ps = conn.prepareStatement("DELETE FROM aeroport WHERE id = ?");

			ps.setLong(1, id);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
