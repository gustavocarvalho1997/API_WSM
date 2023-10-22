package br.com.fiap.wsm.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.wsm.dao.CategoriaDao;
import br.com.fiap.wsm.dao.ProdutoDao;
import br.com.fiap.wsm.exception.BadInfoException;
import br.com.fiap.wsm.exception.IdNotFoundException;
import br.com.fiap.wsm.factory.ConnectionFactory;
import br.com.fiap.wsm.model.Categoria;
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
	}//Cadastrar FIM
	
	//Listar INICIO
	public List<Produto> listar() throws SQLException {
		List<Produto> listaProduto = produtoDao.listar();
		List<Categoria> listaCategoria = categoriaDao.listar();
		for(Produto produto : listaProduto) {
			if(produto.getCategoria() != null) {
				for(Categoria categoria : listaCategoria) {
					if(produto.getCategoria().getId() == categoria.getId()) {
						produto.setCategoria(categoria);
						break;
					}//IF
				}//FOR CATEGORIA
			}//IF
		}//FOR PRODUTO
		return listaProduto;
	}//Listar FIM
	
	//PesquisarPorId INICIO
	public Produto pesquisarPorId(int id) throws SQLException, IdNotFoundException {
		Produto p = produtoDao.pesquisarPorId(id);
		if(p.getCategoria() != null) {
			Categoria c = categoriaDao.pesquisarPorId(p.getCategoria().getId());
			p.setCategoria(c);
		}
		return p;
	}//PesquisarPorId FIM
	
	//Atualizar INICIO
	public void atualizar(Produto produto) throws SQLException, IdNotFoundException {
		Produto modelo = produtoDao.pesquisarPorId(produto.getId());
		if(produto.getNome() == null) {
			produto.setNome(modelo.getNome());
		}
		if(produto.getPreco() == 0) {
			produto.setPreco(modelo.getPreco());
		}
		if(produto.getPeso() == 0) {
			produto.setPeso(modelo.getPeso());
		}
		if(produto.getTipo() == null) {
			produto.setTipo(modelo.getTipo());
		}
		if(produto.getCategoria() == null) {
			produto.setCategoria(modelo.getCategoria());
		}
		produtoDao.atualizar(produto);
	}//Atualizar FIM
	
	//Deletar INICIO
	public void deletar(int id) throws SQLException, IdNotFoundException {
		produtoDao.deletar(id);
	}//Deletar FIM
}//CLASS