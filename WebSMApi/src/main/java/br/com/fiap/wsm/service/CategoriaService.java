package br.com.fiap.wsm.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.wsm.dao.CategoriaDao;
import br.com.fiap.wsm.exception.BadInfoException;
import br.com.fiap.wsm.exception.IdNotFoundException;
import br.com.fiap.wsm.factory.ConnectionFactory;
import br.com.fiap.wsm.model.Categoria;
import br.com.fiap.wsm.model.Produto;

public class CategoriaService {
	// Atributos
	private CategoriaDao categoriaDao;
	private ProdutoService produtoService;
	
	// Construtor
	public CategoriaService() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.getConnection();
		categoriaDao = new CategoriaDao(conn);
		produtoService = new ProdutoService();
	}

	//Cadastrar INICIO
	public void cadastrar(Categoria categoria) throws SQLException, BadInfoException{
		if(categoria.getNome() == null || categoria.getNome().length() > 30) {
			throw new BadInfoException("Nome inválido, não pode ser nulo e deve conter no máximo 30 caracteres!");
		}
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
	public void atualizar(Categoria categoria) throws SQLException, IdNotFoundException, BadInfoException {
		Categoria modelo = categoriaDao.pesquisarPorId(categoria.getId());
		if(categoria.getNome() == null) {
			categoria.setNome(modelo.getNome());
		}	
		if(categoria.getNome().length() > 30) {
			throw new BadInfoException("O nome não pode exceder 30 caracteres!");
		}
		categoriaDao.atualizar(categoria);
	}//Atualizar FIM
	
	//Deletar INICIO
	public void deletar(int id) throws SQLException, IdNotFoundException, BadInfoException {
		List<Produto> listaProduto = produtoService.listar();
		Categoria c = categoriaDao.pesquisarPorId(id);
		for(Produto produto : listaProduto) {
			if(produto.getCategoria().getId() == c.getId()) {
				throw new BadInfoException("A categoria não pode ser excluida, há registros que a utilizam como referência");
			}
		}
		categoriaDao.deletar(id);
	}//Deletar FIM
}//CLASS