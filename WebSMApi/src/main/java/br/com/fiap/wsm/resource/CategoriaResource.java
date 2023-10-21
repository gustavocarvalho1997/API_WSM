package br.com.fiap.wsm.resource;

import java.sql.SQLException;

import br.com.fiap.wsm.service.CategoriaService;
import jakarta.ws.rs.Path;

@Path("/categoria")
public class CategoriaResource {
	// Atributo
	private CategoriaService service;
	//Construtor
	public CategoriaResource() throws ClassNotFoundException, SQLException {
		service = new CategoriaService();
	}
}//CLASS