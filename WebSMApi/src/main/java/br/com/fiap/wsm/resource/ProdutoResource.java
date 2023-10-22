package br.com.fiap.wsm.resource;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.wsm.exception.BadInfoException;
import br.com.fiap.wsm.exception.IdNotFoundException;
import br.com.fiap.wsm.model.Produto;
import br.com.fiap.wsm.service.ProdutoService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("/produto")
public class ProdutoResource {
	// Atributo
	private ProdutoService service;
	// Construtor
	public ProdutoResource() throws ClassNotFoundException, SQLException {
		service = new ProdutoService();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Produto produto, @Context UriInfo uriInfo) throws SQLException {
		try {
			service.cadastrar(produto);
			UriBuilder builder = uriInfo.getAbsolutePathBuilder();
			builder.path(Integer.toString(produto.getId()));
			return Response.created(builder.build()).build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (BadInfoException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> lista() throws SQLException{
		return service.listar();
	}
}//CLASS