package br.com.fiap.wsm.service;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.wsm.dao.CategoriaDao;
import br.com.fiap.wsm.dao.ProdutoDao;
import br.com.fiap.wsm.exception.BadInfoException;
import br.com.fiap.wsm.exception.IdNotFoundException;
import br.com.fiap.wsm.factory.ConnectionFactory;
import br.com.fiap.wsm.model.Produto;

public class ProdutoService {
	//Atributos
	private ProdutoDao produtoDao;
	private CategoriaDao categoriaDao;
	
	//Construtor
	public ProdutoService() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.getConnection();
		produtoDao = new ProdutoDao(conn);
		categoriaDao = new CategoriaDao(conn);
	}
	
	//Cadastrar INICIO
	public void cadastrar(Produto produto) throws SQLException, IdNotFoundException, BadInfoException {
		//Verifica se o id da categoria que será a FK existe na tabela
		if(produto.getCategoria() != null) {
			categoriaDao.pesquisarPorId(produto.getCategoria().getId());
		}
		//Verifica nome
		if(produto.getNome() == null || produto.getNome().length() > 50) {
			throw new BadInfoException("Nome inválido, não pode ser nulo e deve ter no máximo 50 caracteres!");
		}
		
		produtoDao.cadastrar(produto);
	}
}//CLASS