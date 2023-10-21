package br.com.fiap.wsm.model;

import lombok.Data;

@SuppressWarnings("unused")
@Data
public class Categoria {
	// Atributos
	private int id;
	private String nome;
	private boolean perecivel;
	// Construtores
	public Categoria(int id, String nome, boolean perecivel) {
		super();
		this.id = id;
		this.nome = nome;
		this.perecivel = perecivel;
	}
	public Categoria() {
		super();
	}
	
}//CLASS
