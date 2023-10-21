package br.com.fiap.wsm.service;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.wsm.dao.CategoriaDao;
import br.com.fiap.wsm.factory.ConnectionFactory;
import br.com.fiap.wsm.model.Categoria;

public class CategoriaService {
	// Atributos
	private CategoriaDao categoriaDao;
	
	// Construtor
	public CategoriaService() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.getConnection();
		categoriaDao = new CategoriaDao(conn);
	}

	//Cadastrar INICIO
	public void cadastrar(Categoria categoria) throws ClassNotFoundException, SQLException{
		categoriaDao.cadastrar(categoria);
	}//Cadastrar FIM
}//CLASS