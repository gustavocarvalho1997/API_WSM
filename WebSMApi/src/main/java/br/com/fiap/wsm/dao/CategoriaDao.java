package br.com.fiap.wsm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.wsm.exception.IdNotFoundException;
import br.com.fiap.wsm.interfaces.ICategoriaDao;
import br.com.fiap.wsm.model.Categoria;

public class CategoriaDao implements ICategoriaDao {
	// Atributos
	private Connection conn;
	// Statements
	private static final String CADASTRAR = "INSERT INTO T_WSM_CATEGORIA (ID_CATEGORIA, NM_CATEGORIA, ST_PERECIVEL) VALUES (SEQ_WSM_CATEGORIA.NEXTVAL, ?, ?)";
	private static final String LISTAR = "SELECT * FROM T_WSM_CATEGORIA ORDER BY ID_CATEGORIA";
	private static final String PESQ_ID = "SELECT * FROM T_WSM_CATEGORIA WHERE ID_CATEGORIA = ?";
	private static final String ATUALIZAR = "UPDATE T_WSM_CATEGORIA SET NM_CATEGORIA = ?, ST_PERECIVEL = ? WHERE ID_CATEGORIA = ?";
	private static final String DELETAR = "DELETE FROM T_WSM_CATEGORIA WHERE ID_CATEGORIA = ?";
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
	
	//pesquisarPorId INICIO
	public Categoria pesquisarPorId(int id) throws SQLException, IdNotFoundException {
		PreparedStatement stm = conn.prepareStatement(PESQ_ID);
		stm.setInt(1, id);
		ResultSet rs = stm.executeQuery();
		if(!rs.next()) {
			throw new IdNotFoundException("Categoria não encontrada");
		}
		Categoria categoria = parse(rs);
		return categoria;
	}//pesquisarPorId FIM
	
	//Atualizar INICIO
	public void atualizar(Categoria categoria) throws SQLException, IdNotFoundException {
		pesquisarPorId(categoria.getId());
		PreparedStatement stm = conn.prepareStatement(ATUALIZAR);
		stm.setString(1, categoria.getNome());
		stm.setBoolean(2, categoria.isPerecivel());
		stm.setInt(3, categoria.getId());
		
		stm.executeUpdate();
	}//Atualizar FIM
	
	//Deletar INICIO
	public void deletar(int id) throws SQLException, IdNotFoundException {
		pesquisarPorId(id);
		PreparedStatement stm = conn.prepareStatement(DELETAR);
		stm.setInt(1, id);
		
		stm.executeUpdate();
	}//Deletar FIM
}//CLASS