package br.com.fiap.wsm.model;

import lombok.Data;

@Data
public class Produto {
	// Atributos
	private int id;
	private String nome;
	private double preco, peso;
	private String tipo;
	private Categoria categoria;
	// Construtores
	public Produto(int id, String nome, double preco, double peso, String tipo, Categoria categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.peso = peso;
		this.tipo = tipo;
		this.categoria = categoria;
	}
	public Produto() {
		super();
	}
	
}//CLASS