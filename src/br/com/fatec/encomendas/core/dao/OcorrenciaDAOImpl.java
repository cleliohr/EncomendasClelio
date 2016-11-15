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

import br.com.fatec.encomendas.api.dao.EncomendaDAO;
import br.com.fatec.encomendas.api.dao.OcorrenciaDAO;
import br.com.fatec.encomendas.api.dao.ViagemDAO;
import br.com.fatec.encomendas.api.entity.Ocorrencia;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class OcorrenciaDAOImpl implements OcorrenciaDAO {

	private EncomendaDAO encomendaDao;
	private ViagemDAO viagemDao;

	public OcorrenciaDAOImpl() {
		this.encomendaDao = ImplFinder.getImpl(EncomendaDAO.class);
		this.viagemDao = ImplFinder.getImpl(ViagemDAO.class);
	}

	public Long save(Ocorrencia ocorrencia) {
		Connection conn = null;
		PreparedStatement insert = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();

			String colunas = DAOUtils.getColunas(getDefaultConnectionType(), Ocorrencia.getColunas());

			String values = DAOUtils.completarClausulaValues(getDefaultConnectionType(), 5, "SEQ_OCORRENCIA");

			String sql = "INSERT INTO " + Ocorrencia.TABLE + colunas + " VALUES " + values;

			insert = DAOUtils.criarStatment(sql, conn, getDefaultConnectionType(), Ocorrencia.getColunasArray());

			insert.setLong(1, ocorrencia.getEncomenda().getId());

			if (ocorrencia.getViagem().getId() == null)
				insert.setNull(2, java.sql.Types.INTEGER);
			else
				insert.setLong(2, ocorrencia.getViagem().getId());

			insert.setString(3, ocorrencia.getDescricao());
			insert.setLong(4, ocorrencia.getDataHora().getTime());
			insert.setString(5, ocorrencia.getTipoOcorrencia());
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

	public void update(Ocorrencia ocorrencia) {
		Connection conn = null;
		PreparedStatement update = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			update = conn.prepareStatement("UPDATE " + Ocorrencia.TABLE + " SET " + Ocorrencia.COL_ENCOMENDA_ID
					+ " = ?, " + Ocorrencia.COL_VIAGEM_ID + " = ?, " + Ocorrencia.COL_DESCRICAO + " = ?, "
					+ Ocorrencia.COL_DATA_HORA + " = ?, " + Ocorrencia.COL_TIPO_OCORRENCIA + " = ? " + " WHERE "
					+ Ocorrencia.COL_ID + " = ?");
			update.setLong(1, ocorrencia.getEncomenda().getId());
			update.setLong(2, ocorrencia.getViagem().getId());
			update.setString(3, ocorrencia.getDescricao());
			update.setLong(4, ocorrencia.getDataHora().getTime());
			update.setString(5, ocorrencia.getTipoOcorrencia());
			update.setLong(6, ocorrencia.getId());
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
			String sql = "DELETE FROM " + Ocorrencia.TABLE + " WHERE ID = ?";
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

	public Ocorrencia findById(Long id) {
		Connection conn = null;
		PreparedStatement find = null;
		Ocorrencia ocorrencia = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Ocorrencia.TABLE + " WHERE " + Ocorrencia.COL_ID + " = ?";
			find = conn.prepareStatement(sql);
			find.setLong(1, id);
			ResultSet rs = find.executeQuery();
			if (rs.next()) {
				ocorrencia = this.buildOcorrencia(rs);
			}
			return ocorrencia;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(find);
		}
	}

	public List<Ocorrencia> findAll() {
		Connection conn = null;
		PreparedStatement findAll = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			findAll = conn.prepareStatement("SELECT * FROM " + Ocorrencia.TABLE);
			ResultSet rs = findAll.executeQuery();
			return this.buildOcorrencias(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(findAll);
		}
	}

	@Override
	public List<Ocorrencia> findByEncomenda(Long id) {
		Connection conn = null;
		PreparedStatement findByEncomenda = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			findByEncomenda = conn.prepareStatement(
					"SELECT * FROM " + Ocorrencia.TABLE + " WHERE " + Ocorrencia.COL_ENCOMENDA_ID + " = " + id);
			ResultSet rs = findByEncomenda.executeQuery();
			return this.buildOcorrencias(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(findByEncomenda);
		}
	}

	private List<Ocorrencia> buildOcorrencias(ResultSet rs) throws SQLException {
		List<Ocorrencia> ocorrencias = Lists.newArrayList();
		while (rs.next()) {
			ocorrencias.add(this.buildOcorrencia(rs));
		}
		return ocorrencias;
	}

	private Ocorrencia buildOcorrencia(ResultSet rs) throws SQLException {
		Ocorrencia ocorrencia = new Ocorrencia();
		ocorrencia.setId(rs.getLong(Ocorrencia.COL_ID));
		ocorrencia.setEncomenda(this.encomendaDao.findById(rs.getLong(Ocorrencia.COL_ENCOMENDA_ID)));
		ocorrencia.setViagem(this.viagemDao.findById(rs.getLong(Ocorrencia.COL_VIAGEM_ID)));
		ocorrencia.setDescricao(rs.getString(Ocorrencia.COL_DESCRICAO));
		ocorrencia.setDataHora( new Date(rs.getLong(Ocorrencia.COL_DATA_HORA)));
		ocorrencia.setTipoOcorrencia(rs.getString(Ocorrencia.COL_TIPO_OCORRENCIA));
		return ocorrencia;
	}

}
