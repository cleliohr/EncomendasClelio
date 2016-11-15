package br.com.fatec.encomendas.core.dao;

import static br.com.spektro.minispring.core.dbmapper.ConfigDBMapper.getDefaultConnectionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.google.common.collect.Lists;

import br.com.fatec.encomendas.api.dao.EnderecoDAO;
import br.com.fatec.encomendas.api.dao.ZonaDAO;
import br.com.fatec.encomendas.api.entity.Cidade;
import br.com.fatec.encomendas.api.entity.Endereco;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class EnderecoDAOImpl implements EnderecoDAO {

	private ZonaDAO zonaDao;

	public EnderecoDAOImpl() {
		this.zonaDao = ImplFinder.getImpl(ZonaDAO.class);
	}

	public Long save(Endereco endereco) {
		Connection conn = null;
		PreparedStatement insert = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();

			String colunas = DAOUtils.getColunas(getDefaultConnectionType(), Endereco.getColunas());

			String values = DAOUtils.completarClausulaValues(getDefaultConnectionType(), 2, "SEQ_ENDERECO");

			String sql = "INSERT INTO " + Endereco.TABLE + colunas + " VALUES " + values;

			insert = DAOUtils.criarStatment(sql, conn, getDefaultConnectionType(), Endereco.getColunasArray());

			insert.setString(1, endereco.getCep());
			insert.setString(2, endereco.getCidade().name());
			insert.setString(3, endereco.getLogradouro());
			insert.setString(4, endereco.getBairro());
			insert.setLong(5, endereco.getZona().getId());
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

	public void update(Endereco endereco) {
		Connection conn = null;
		PreparedStatement update = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			update = conn.prepareStatement("UPDATE " + Endereco.TABLE + " SET " + Endereco.COL_CEP + " = ?, "
					+ Endereco.COL_CIDADE_ID + " = ?, " + Endereco.COL_LOGRADOURO + " = ?, " + Endereco.COL_BAIRRO
					+ " = ?, " + Endereco.COL_ZONA_ID + " = ? " + " WHERE " + Endereco.COL_ID + " = ?");
			update.setString(1, endereco.getCep());
			update.setString(2, endereco.getCidade().name());
			update.setString(3, endereco.getLogradouro());
			update.setString(4, endereco.getBairro());
			update.setLong(5, endereco.getZona().getId());
			update.setLong(6, endereco.getId());
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
			String sql = "DELETE FROM " + Endereco.TABLE + " WHERE ID = ?";
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

	public Endereco findById(Long id) {
		Connection conn = null;
		PreparedStatement find = null;
		Endereco endereco = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Endereco.TABLE + " WHERE " + Endereco.COL_ID + " = ?";
			find = conn.prepareStatement(sql);
			find.setLong(1, id);
			ResultSet rs = find.executeQuery();
			if (rs.next()) {
				endereco = this.buildEndereco(rs);
			}
			return endereco;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(find);
		}
	}

	public List<Endereco> findAll() {
		Connection conn = null;
		PreparedStatement findAll = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			findAll = conn.prepareStatement("SELECT * FROM " + Endereco.TABLE);
			ResultSet rs = findAll.executeQuery();
			return this.buildEnderecos(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(findAll);
		}
	}

	private List<Endereco> buildEnderecos(ResultSet rs) throws SQLException {
		List<Endereco> enderecos = Lists.newArrayList();
		while (rs.next()) {
			enderecos.add(this.buildEndereco(rs));
		}
		return enderecos;
	}

	private Endereco buildEndereco(ResultSet rs) throws SQLException {
		Endereco endereco = new Endereco();
		endereco.setId(rs.getLong(Endereco.COL_ID));
		endereco.setCep(rs.getString(Endereco.COL_CEP));
		endereco.setCidade(Cidade.valueOf(rs.getString(Endereco.COL_CIDADE_ID)));
		endereco.setLogradouro(rs.getString(Endereco.COL_LOGRADOURO));
		endereco.setBairro(rs.getString(Endereco.COL_BAIRRO));
		endereco.setZona(this.zonaDao.findById(rs.getLong(Endereco.COL_ZONA_ID)));
		return endereco;
	}
}
