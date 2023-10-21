package br.com.fiap.wsm.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.wsm.dao.CategoriaDao;
import br.com.fiap.wsm.exception.IdNotFoundException;
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
	public void cadastrar(Categoria categoria) throws SQLException{
		categoriaDao.cadastrar(categoria);
	}//Cadastrar FIM
	
	//Listar INICIO
	public List<Categoria> listar() throws SQLException {
		List<Categoria> lista = categoriaDao.listar();
		return lista;
	}//Listar FIM
	
	//pesquisarPorId INICIO
	public Categoria pesquisarPorId(int id) throws SQLException, IdNotFoundException {
		Categoria categoria = categoriaDao.pesquisarPorId(id);
		return categoria;
	}//pesquisarPorId FIM
	
	//Atualizar INICIO
	public void atualizar(Categoria categoria) throws SQLException, IdNotFoundException {
		categoriaDao.atualizar(categoria);
	}//Atualizar FIM
	
	//Deletar INICIO
	public void deletar(int id) throws SQLException, IdNotFoundException {
		categoriaDao.deletar(id);
	}
}//CLASS