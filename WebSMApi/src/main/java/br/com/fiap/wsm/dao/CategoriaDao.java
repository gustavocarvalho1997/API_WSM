package br.com.fiap.wsm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.wsm.model.Categoria;

public class CategoriaDao {
	// Atributos
	private Connection conn;
	// Statements
	private static final String CADASTRAR = "INSERT INTO T_WSM_CATEGORIA (ID_CATEGORIA, NM_CATEGORIA, ST_PERECIVEL) VALUES (SEQ_WSM_CATEGORIA.NEXTVAL, ?, ?)";
	
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
}//CLASS