package br.com.fiap.wsm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.wsm.model.Categoria;

public class CategoriaDao {
	// Atributos
	private Connection conn;
	// Statements
	private static final String CADASTRAR = "INSERT INTO T_WSM_CATEGORIA (ID_CATEGORIA, NM_CATEGORIA, ST_PERECIVEL) VALUES (SEQ_WSM_CATEGORIA.NEXTVAL, ?, ?)";
	private static final String LISTAR = "SELECT * FROM T_WSM_CATEGORIA ORDER BY ID_CATEGORIA";
	private static final String PESQ_ID = "SELECT * FROM T_WSM_CATEGORIA WHERE ID_CATEGORIA = ?";
	// Construtor
	public CategoriaDao(Connection conn) {
		this.conn = conn;
	}//CategoriaDao
	
	//Parse INICIO
	private Categoria parse(ResultSet rs) throws SQLException {
		int id = rs.getInt("ID_CATEGORIA");
		String nome = rs.getString("NM_CATEGORIA");
		boolean perecivel = (rs.getInt("ST_PERECIVEL") == 1) ? true : false;
		Categoria categoria = new Categoria(id, nome, perecivel);
		return categoria;
	}//Parse FIM
	
	//Cadastrar INICIO
	public void cadastrar(Categoria categoria) throws SQLException {
		PreparedStatement stm = conn.prepareStatement(CADASTRAR);
		stm.setString(1, categoria.getNome());
		stm.setBoolean(2, categoria.isPerecivel());
		
		stm.executeUpdate();
	}//Cadastrar FIM
	
	//Listar INICIO
	public List<Categoria> listar() throws SQLException {
		PreparedStatement stm = conn.prepareStatement(LISTAR);
		ResultSet rs = stm.executeQuery();
		List<Categoria> lista = new ArrayList<>();
		while(rs.next()) {
			Categoria categoria = parse(rs);
			lista.add(categoria);
		}
		return lista;
	}//Listar FIM
}//CLASS