package br.com.fatec.encomendas.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.google.common.collect.Lists;

import br.com.fatec.encomendas.api.dao.ViewAgruparDAO;
import br.com.fatec.encomendas.api.entity.ViewAgrupar;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;

public class ViewAgruparDAOImpl implements ViewAgruparDAO {

	public ViewAgruparDAOImpl() {

	}

	@Override
	public List<ViewAgrupar> findAll() {
		Connection conn = null;
		PreparedStatement findAll = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			findAll = conn.prepareStatement("SELECT * FROM " + ViewAgrupar.TABLE);
			ResultSet rs = findAll.executeQuery();
			return this.buildViewsAgrupar(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(findAll);
		}
	}

	private List<ViewAgrupar> buildViewsAgrupar(ResultSet rs) throws SQLException {
		List<ViewAgrupar> viewAgrupar = Lists.newArrayList();
		while (rs.next()) {
			viewAgrupar.add(this.buildViewAgrupar(rs));
		}
		return viewAgrupar;
	}

	private ViewAgrupar buildViewAgrupar(ResultSet rs) throws SQLException {
		ViewAgrupar viewAgrupar = new ViewAgrupar();
		viewAgrupar.setEncomendaDescricao(rs.getString(ViewAgrupar.COL_ENCOMENDA_DESCRICAO));
		viewAgrupar.setUsuarioNome(rs.getString(ViewAgrupar.COL_USUARIO_NOME));
		viewAgrupar.setVeiculoNome(rs.getString(ViewAgrupar.COL_VEICULO_NOME));
		viewAgrupar.setStatus(rs.getString(ViewAgrupar.COL_STATUS));
		return viewAgrupar;
	}

}
