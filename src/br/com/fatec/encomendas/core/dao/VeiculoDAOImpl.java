package br.com.fatec.encomendas.core.dao;

import static br.com.spektro.minispring.core.dbmapper.ConfigDBMapper.getDefaultConnectionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.google.common.collect.Lists;

import br.com.fatec.encomendas.api.dao.VeiculoDAO;
import br.com.fatec.encomendas.api.dao.ZonaDAO;
import br.com.fatec.encomendas.api.entity.Usuario;
import br.com.fatec.encomendas.api.entity.Veiculo;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class VeiculoDAOImpl implements VeiculoDAO {

	private ZonaDAO zonaDao;

	public VeiculoDAOImpl() {
		zonaDao = ImplFinder.getImpl(ZonaDAO.class);
	}

	public Long save(Veiculo veiculo) {
		Connection conn = null;
		PreparedStatement insert = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();

			String colunas = DAOUtils.getColunas(ConfigDBMapper.getDefaultConnectionType(), Veiculo.getColunas());

			String values = DAOUtils.completarClausulaValues(getDefaultConnectionType(), 2, "SEQ_VEICULO");

			String sql = "INSERT INTO " + Veiculo.TABLE + colunas + " VALUES " + values;

			insert = DAOUtils.criarStatment(sql, conn, getDefaultConnectionType(), Veiculo.getColunasArray());

			insert.setString(1, veiculo.getNome());
			insert.setLong(2, veiculo.getZona().getId());
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

	public void update(Veiculo veiculo) {
		Connection conn = null;
		PreparedStatement update = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			update = conn.prepareStatement("UPDATE " + Usuario.TABLE + " SET " + Veiculo.COL_NOME + " = ?, "
					+ Veiculo.COL_ZONA_ID + " = ? " + " WHERE " + Veiculo.COL_ID + " = ?");
			update.setString(1, veiculo.getNome());
			update.setLong(2, veiculo.getZona().getId());
			update.setLong(3, veiculo.getId());
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
			String sql = "DELETE FROM " + Veiculo.TABLE + " WHERE ID = ?";
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

	public Veiculo findById(Long id) {
		Connection conn = null;
		PreparedStatement find = null;
		Veiculo veiculo = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Veiculo.TABLE + " WHERE " + Veiculo.COL_ID + " = ?";
			find = conn.prepareStatement(sql);
			find.setLong(1, id);
			ResultSet rs = find.executeQuery();
			if (rs.next()) {
				veiculo = this.buildVeiculo(rs);
			}
			return veiculo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(find);
		}
	}

	public List<Veiculo> findAll() {
		Connection conn = null;
		PreparedStatement findAll = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			findAll = conn.prepareStatement("SELECT * FROM " + Veiculo.TABLE);
			ResultSet rs = findAll.executeQuery();
			return this.buildVeiculos(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(findAll);
		}
	}

	private List<Veiculo> buildVeiculos(ResultSet rs) throws SQLException {
		List<Veiculo> veiculo = Lists.newArrayList();
		while (rs.next()) {
			veiculo.add(this.buildVeiculo(rs));
		}
		return veiculo;
	}

	private Veiculo buildVeiculo(ResultSet rs) throws SQLException {
		Veiculo veiculo = new Veiculo();
		veiculo.setId(rs.getLong(Veiculo.COL_ID));
		veiculo.setNome(rs.getString(Veiculo.COL_NOME));
		veiculo.setZona(this.zonaDao.findById(rs.getLong(Veiculo.COL_ZONA_ID)));
		return veiculo;
	}
}
