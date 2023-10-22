package br.com.fiap.wsm.interfaces;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.wsm.exception.IdNotFoundException;
import br.com.fiap.wsm.model.Categoria;

public interface ICadastrarDao {

	//Cadastrar INICIO
	void cadastrar(Categoria categoria) throws SQLException;//Cadastrar FIM

	//Listar INICIO
	List<Categoria> listar() throws SQLException;//Listar FIM

	//pesquisarPorId INICIO
	Categoria pesquisarPorId(int id) throws SQLException, IdNotFoundException;//pesquisarPorId FIM

	//Atualizar INICIO
	void atualizar(Categoria categoria) throws SQLException, IdNotFoundException;//Atualizar FIM

	//Deletar INICIO
	void deletar(int id) throws SQLException, IdNotFoundException;//Deletar FIM

}