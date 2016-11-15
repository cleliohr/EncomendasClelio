package br.com.fatec.encomendas.core.dao;

import static br.com.spektro.minispring.core.dbmapper.ConfigDBMapper.getDefaultConnectionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.google.common.collect.Lists;

import br.com.fatec.encomendas.api.dao.EncomendaDAO;
import br.com.fatec.encomendas.api.dao.UsuarioDAO;
import br.com.fatec.encomendas.api.entity.Encomenda;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class EncomendaDAOImpl implements EncomendaDAO {

	private UsuarioDAO usuario;

	public EncomendaDAOImpl() {
		this.usuario = ImplFinder.getImpl(UsuarioDAO.class);
	}

	public Long save(Encomenda encomenda) {
		Connection conn = null;
		PreparedStatement insert = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();

			String colunas = DAOUtils.getColunas(getDefaultConnectionType(), Encomenda.getColunas());

			String values = DAOUtils.completarClausulaValues(getDefaultConnectionType(), 3, "SEQ_ENCOMENDA");

			String sql = "INSERT INTO " + Encomenda.TABLE + colunas + " VALUES " + values;

			insert = DAOUtils.criarStatment(sql, conn, getDefaultConnectionType(), Encomenda.getColunasArray());

			insert.setLong(1, encomenda.getUsuario().getId());
			insert.setString(2, "aguardando");
			insert.setString(3, encomenda.getDescricao());
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

	public void update(Encomenda encomenda) {
		Connection conn = null;
		PreparedStatement update = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			update = conn.prepareStatement(
					"UPDATE " + Encomenda.TABLE + " SET " + Encomenda.COL_USUARIO_ID + " = ?, " + Encomenda.COL_STATUS
							+ " = ?, " + Encomenda.COL_DESCRICAO + " = ? " + " WHERE " + Encomenda.COL_ID + " = ?");
			update.setLong(1, encomenda.getUsuario().getId());
			update.setString(2, encomenda.getStatus());
			update.setString(3, encomenda.getDescricao());
			update.setLong(4, encomenda.getId());
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
			String sql = "DELETE FROM " + Encomenda.TABLE + " WHERE ID = ?";
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

	public Encomenda findById(Long id) {
		Connection conn = null;
		PreparedStatement find = null;
		Encomenda encomenda = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Encomenda.TABLE + " WHERE " + Encomenda.COL_ID + " = ?";
			find = conn.prepareStatement(sql);
			find.setLong(1, id);
			ResultSet rs = find.executeQuery();
			if (rs.next()) {
				encomenda = this.buildEncomenda(rs);
			}
			return encomenda;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(find);
		}
	}

	public List<Encomenda> findAll() {
		Connection conn = null;
		PreparedStatement findAll = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			findAll = conn.prepareStatement("SELECT * FROM " + Encomenda.TABLE);
			ResultSet rs = findAll.executeQuery();
			return this.buildEncomendas(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(findAll);
		}
	}

	private List<Encomenda> buildEncomendas(ResultSet rs) throws SQLException {
		List<Encomenda> encomendas = Lists.newArrayList();
		while (rs.next()) {
			encomendas.add(this.buildEncomenda(rs));
		}
		return encomendas;
	}

	private Encomenda buildEncomenda(ResultSet rs) throws SQLException {
		Encomenda encomenda = new Encomenda();
		encomenda.setId(rs.getLong(Encomenda.COL_ID));
		encomenda.setStatus(rs.getString(Encomenda.COL_STATUS));
		encomenda.setUsuario(this.usuario.findById(rs.getLong(Encomenda.COL_USUARIO_ID)));
		encomenda.setDescricao(rs.getString(Encomenda.COL_DESCRICAO));
		return encomenda;
	}

}
