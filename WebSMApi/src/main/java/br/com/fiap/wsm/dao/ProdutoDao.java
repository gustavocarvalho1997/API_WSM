package br.com.fiap.wsm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.wsm.exception.IdNotFoundException;
import br.com.fiap.wsm.interfaces.IProdutoDao;
import br.com.fiap.wsm.model.Categoria;
import br.com.fiap.wsm.model.Produto;

public class ProdutoDao implements IProdutoDao{
	// Atributos
	private Connection conn;
	// Statements
	private static final String CADASTRAR = "INSERT INTO T_WSM_PRODUTO (ID_PRODUTO, NM_PRODUTO, PC_PRODUTO, PS_PRODUTO, TP_PRODUTO, ID_CATEGORIA) VALUES (SEQ_WSM_PRODUTO.NEXTVAL, ?, ?, ?, ?, ?)";
	
	// Construtor
	public ProdutoDao(Connection conn) {
		this.conn = conn;
	}//CategoriaDao
	
	//Parse INICIO
	private Produto parse(ResultSet result) throws SQLException {
		int id = result.getInt("ID_PRODUTO");
		String nome = result.getString("NM_PRODUTO");
		double preco = result.getDouble("PC_PRODUTO");
		double peso = result.getDouble("PS_PRODUTO");
		String tipo = result.getString("TP_PRODUTO");
		int idCategoria = result.getInt("ID_CATEGORIA");
		Produto produto = new Produto(id, nome, preco, peso, tipo, null);
		if(idCategoria != 0) {
			Categoria categoria = new Categoria();
			categoria.setId(idCategoria);
			produto.setCategoria(categoria);
		}
		return produto;
	}//Parse FIM

	//Cadastrar INICIO
	public void cadastrar(Produto produto) throws SQLException {
		PreparedStatement stm = conn.prepareStatement(CADASTRAR);
		stm.setString(1, produto.getNome());
		stm.setDouble(2, produto.getPreco());
		stm.setDouble(3, produto.getPeso());
		stm.setString(4, produto.getTipo());
		stm.setInt(5, produto.getCategoria().getId());
		
		stm.executeUpdate();
	}//Cadastrar FIM

	public List<Produto> listar() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Produto pesquisarPorId(int id) throws SQLException, IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public void atualizar(Produto produto) throws SQLException, IdNotFoundException {
		// TODO Auto-generated method stub
		
	}

	public void deletar(int id) throws SQLException, IdNotFoundException {
		// TODO Auto-generated method stub
		
	}
	
	
}//CLASS