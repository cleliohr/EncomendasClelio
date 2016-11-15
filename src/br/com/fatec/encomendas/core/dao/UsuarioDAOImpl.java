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
import br.com.fatec.encomendas.api.dao.UsuarioDAO;
import br.com.fatec.encomendas.api.entity.Usuario;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class UsuarioDAOImpl implements UsuarioDAO {

	private EnderecoDAO enderecoDao;

	public UsuarioDAOImpl() {
		this.enderecoDao = ImplFinder.getImpl(EnderecoDAO.class);
	}

	public Long save(Usuario usuario) {
		Connection conn = null;
		PreparedStatement insert = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();

			String colunas = DAOUtils.getColunas(ConfigDBMapper.getDefaultConnectionType(), Usuario.getColunas());

			String values = DAOUtils.completarClausulaValues(getDefaultConnectionType(), 2, "SEQ_USUARIO");

			String sql = "INSERT INTO " + Usuario.TABLE + colunas + " VALUES " + values;

			insert = DAOUtils.criarStatment(sql, conn, getDefaultConnectionType(), Usuario.getColunasArray());

			insert.setString(1, usuario.getNome());
			insert.setLong(2, usuario.getEndereco().getId());
			insert.setString(3, usuario.getNumero());
			insert.setString(4, usuario.getComplemento());
			insert.setString(5, usuario.getCpf());
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

	public void update(Usuario usuario) {
		Connection conn = null;
		PreparedStatement update = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			update = conn.prepareStatement("UPDATE " + Usuario.TABLE + " SET " + Usuario.COL_NOME + " = ?, "
					+ Usuario.COL_ENDERECO_ID + " = ?, " + Usuario.COL_NUMERO + " = ?, " + Usuario.COL_COMPLEMENTO
					+ " = ?, " + Usuario.COL_CPF + " = ? " + " WHERE " + Usuario.COL_ID + " = ?");
			update.setString(1, usuario.getNome());
			update.setLong(2, usuario.getEndereco().getId());
			update.setString(3, usuario.getNumero());
			update.setString(4, usuario.getComplemento());
			update.setString(5, usuario.getCpf());
			update.setLong(6, usuario.getId());
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
			String sql = "DELETE FROM " + Usuario.TABLE + " WHERE ID = ?";
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

	public Usuario findById(Long id) {
		Connection conn = null;
		PreparedStatement find = null;
		Usuario usuario = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Usuario.TABLE + " WHERE " + Usuario.COL_ID + " = ?";
			find = conn.prepareStatement(sql);
			find.setLong(1, id);
			ResultSet rs = find.executeQuery();
			if (rs.next()) {
				usuario = this.buildUsuario(rs);
			}
			return usuario;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(find);
		}
	}

	public List<Usuario> findAll() {
		Connection conn = null;
		PreparedStatement findAll = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			findAll = conn.prepareStatement("SELECT * FROM " + Usuario.TABLE);
			ResultSet rs = findAll.executeQuery();
			return this.buildUsuarios(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(findAll);
		}
	}

	private List<Usuario> buildUsuarios(ResultSet rs) throws SQLException {
		List<Usuario> usuarios = Lists.newArrayList();
		while (rs.next()) {
			usuarios.add(this.buildUsuario(rs));
		}
		return usuarios;
	}

	private Usuario buildUsuario(ResultSet rs) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setId(rs.getLong(Usuario.COL_ID));
		usuario.setNome(rs.getString(Usuario.COL_NOME));
		usuario.setEndereco(this.enderecoDao.findById(rs.getLong(Usuario.COL_ENDERECO_ID)));
		usuario.setNumero(rs.getString(Usuario.COL_NUMERO));
		usuario.setComplemento(rs.getString(Usuario.COL_COMPLEMENTO));
		usuario.setCpf(rs.getString(Usuario.COL_CPF));
		return usuario;
	}
}
