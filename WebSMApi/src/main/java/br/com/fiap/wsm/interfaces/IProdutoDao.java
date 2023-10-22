package br.com.fiap.wsm.interfaces;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.wsm.exception.IdNotFoundException;
import br.com.fiap.wsm.model.Produto;

public interface IProdutoDao {

	//Cadastrar INICIO
	void cadastrar(Produto produto) throws SQLException;//Cadastrar FIM
	
	//Listar INICIO
	List<Produto> listar() throws SQLException;//Listar FIM

	//pesquisarPorId INICIO
	Produto pesquisarPorId(int id) throws SQLException, IdNotFoundException;//pesquisarPorId FIM

	//Atualizar INICIO
	void atualizar(Produto produto) throws SQLException, IdNotFoundException;//Atualizar FIM

	//Deletar INICIO
	void deletar(int id) throws SQLException, IdNotFoundException;//Deletar FIM

}