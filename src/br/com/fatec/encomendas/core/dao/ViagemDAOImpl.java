package br.com.fatec.encomendas.core.dao;

import static br.com.spektro.minispring.core.dbmapper.ConfigDBMapper.getDefaultConnectionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.google.common.collect.Lists;

import br.com.fatec.encomendas.api.dao.VeiculoDAO;
import br.com.fatec.encomendas.api.dao.ViagemDAO;
import br.com.fatec.encomendas.api.entity.Viagem;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class ViagemDAOImpl implements ViagemDAO {

	private VeiculoDAO veiculoDao;

	public ViagemDAOImpl() {
		veiculoDao = ImplFinder.getImpl(VeiculoDAO.class);
	}

	public Long save(Viagem viagem) {
		Connection conn = null;
		PreparedStatement insert = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();

			String colunas = DAOUtils.getColunas(getDefaultConnectionType(), Viagem.getColunas());

			String values = DAOUtils.completarClausulaValues(getDefaultConnectionType(), 2, "SEQ_VIAGEM");

			String sql = "INSERT INTO " + Viagem.TABLE + colunas + " VALUES " + values;

			insert = DAOUtils.criarStatment(sql, conn, getDefaultConnectionType(), Viagem.getColunasArray());

			insert.setLong(1, viagem.getVeiculo().getId());
			insert.setLong(2, viagem.getData().getTime());
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

	public void update(Viagem viagem) {
		Connection conn = null;
		PreparedStatement update = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			update = conn.prepareStatement("UPDATE " + Viagem.TABLE + " SET " + Viagem.COL_VEICULO_ID + " = ?, "
					+ Viagem.COL_DATA + " = ? " + " WHERE " + Viagem.COL_ID + " = ?");
			update.setLong(1, viagem.getVeiculo().getId());
			update.setLong(2, viagem.getData().getTime());
			update.setLong(5, viagem.getId());
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
			String sql = "DELETE FROM " + Viagem.TABLE + " WHERE ID = ?";
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

	public Viagem findById(Long id) {
		Connection conn = null;
		PreparedStatement find = null;
		Viagem viagem = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Viagem.TABLE + " WHERE " + Viagem.COL_ID + " = ?";
			find = conn.prepareStatement(sql);
			find.setLong(1, id);
			ResultSet rs = find.executeQuery();
			if (rs.next()) {
				viagem = this.buildViagem(rs);
			}
			return viagem;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(find);
		}
	}

	public List<Viagem> findAll() {
		Connection conn = null;
		PreparedStatement findAll = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			findAll = conn.prepareStatement("SELECT * FROM " + Viagem.TABLE);
			ResultSet rs = findAll.executeQuery();
			return this.buildViagens(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(findAll);
		}
	}

	private List<Viagem> buildViagens(ResultSet rs) throws SQLException {
		List<Viagem> viagem = Lists.newArrayList();
		while (rs.next()) {
			viagem.add(this.buildViagem(rs));
		}
		return viagem;
	}

	private Viagem buildViagem(ResultSet rs) throws SQLException {
		Viagem viagem = new Viagem();
		viagem.setId(rs.getLong(Viagem.COL_ID));
		viagem.setVeiculo(this.veiculoDao.findById(rs.getLong(Viagem.COL_VEICULO_ID)));
		viagem.setData(new Date(rs.getLong(Viagem.COL_DATA)));
		return viagem;
	}
}
