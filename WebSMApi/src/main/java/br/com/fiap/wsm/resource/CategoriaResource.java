package br.com.fiap.wsm.resource;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.wsm.exception.IdNotFoundException;
import br.com.fiap.wsm.model.Categoria;
import br.com.fiap.wsm.service.CategoriaService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("/categoria")
public class CategoriaResource {
	// Atributo
	private CategoriaService service;
	//Construtor
	public CategoriaResource() throws ClassNotFoundException, SQLException {
		service = new CategoriaService();
	}
	
	//Cadastrar INICIO
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Categoria categoria, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		service.cadastrar(categoria);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(categoria.getId()));
		return Response.created(builder.build()).build();
	}//Cadastrar FIM
	
	//Listar INICIO
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Categoria> lista() throws SQLException {
		return service.listar();
	}//Listar FIM
	
	//busca INICIO
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response busca(@PathParam("id") int id) throws SQLException {
		try {
			return Response.ok(service.pesquisarPorId(id)).build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}//busca FIM
}//CLASS