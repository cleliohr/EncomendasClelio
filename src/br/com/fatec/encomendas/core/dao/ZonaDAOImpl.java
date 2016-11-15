package br.com.fatec.encomendas.core.dao;

import static br.com.spektro.minispring.core.dbmapper.ConfigDBMapper.getDefaultConnectionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.google.common.collect.Lists;

import br.com.fatec.encomendas.api.dao.ZonaDAO;
import br.com.fatec.encomendas.api.entity.Zona;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;

public class ZonaDAOImpl implements ZonaDAO {

	public Long save(Zona zona) {
		Connection conn = null;
		PreparedStatement insert = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();

			String colunas = DAOUtils.getColunas(getDefaultConnectionType(), Zona.getColunas());

			String values = DAOUtils.completarClausulaValues(getDefaultConnectionType(), 2, "SEQ_ZONA");

			String sql = "INSERT INTO " + Zona.TABLE + colunas + " VALUES " + values;

			insert = DAOUtils.criarStatment(sql, conn, getDefaultConnectionType(), Zona.getColunasArray());

			insert.setString(1, zona.getNome());
			insert.executeUpdate();

			ResultSet generatedKeys = insert.getGeneratedKeys();
			if (generatedKeys.next()) {
				return generatedKeys.getLong(1);
			}

			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(insert);
			DbUtils.closeQuietly(conn);
		}
	}

	public void update(Zona zona) {
		Connection conn = null;
		PreparedStatement update = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			update = conn.prepareStatement(
					"UPDATE " + Zona.TABLE + " SET " + Zona.COL_NOME + " = ? " + " WHERE " + Zona.COL_ID + " = ?");
			update.setString(1, zona.getNome());
			update.setLong(2, zona.getId());
			update.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(update);
		}
	}

	public void delete(Long id) {
		Connection conn = null;
		PreparedStatement delete = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			String sql = "DELETE FROM " + Zona.TABLE + " WHERE ID = ?";
			delete = conn.prepareStatement(sql);
			delete.setLong(1, id);
			delete.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(delete);
			DbUtils.closeQuietly(conn);
		}
	}

	public Zona findById(Long id) {
		Connection conn = null;
		PreparedStatement find = null;
		Zona zona = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Zona.TABLE + " WHERE " + Zona.COL_ID + " = ?";
			find = conn.prepareStatement(sql);
			find.setLong(1, id);
			ResultSet rs = find.executeQuery();
			if (rs.next()) {
				zona = this.buildZona(rs);
			}
			return zona;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(find);
		}
	}

	public List<Zona> findAll() {
		Connection conn = null;
		PreparedStatement findAll = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			findAll = conn.prepareStatement("SELECT * FROM " + Zona.TABLE);
			ResultSet rs = findAll.executeQuery();
			return this.buildZonas(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(findAll);
		}
	}

	private List<Zona> buildZonas(ResultSet rs) throws SQLException {
		List<Zona> zonas = Lists.newArrayList();
		while (rs.next()) {
			zonas.add(this.buildZona(rs));
		}
		return zonas;
	}

	private Zona buildZona(ResultSet rs) throws SQLException {
		Zona zona = new Zona();
		zona.setId(rs.getLong(Zona.COL_ID));
		zona.setNome(rs.getString(Zona.COL_NOME));
		return zona;
	}
}
