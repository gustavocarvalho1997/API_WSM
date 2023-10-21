package br.com.fiap.wsm.model;

import lombok.Data;

@SuppressWarnings("unused")
@Data
public class Categoria {
	
	private int id;
	private String nome;
	private boolean perecivel;
	public Categoria(int id, String nome, boolean perecivel) {
		super();
		this.id = id;
		this.nome = nome;
		this.perecivel = perecivel;
	}
	public Categoria() {
		super();
	}
	
}
