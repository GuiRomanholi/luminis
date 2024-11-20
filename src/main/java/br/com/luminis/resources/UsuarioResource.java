package br.com.luminis.resources;
import br.com.luminis.dto.UsuarioRequestDto;
import br.com.luminis.service.UsuarioService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;
@Path("/usuarios")
public class UsuarioResource {
    private UsuarioService service = new UsuarioService();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrar(UsuarioRequestDto usuario, @Context UriInfo uriInfo) {
        service.cadastrar(usuario);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(usuario.getCpf());
        return Response.created(builder.build())
                .entity("{\"message\": \"Usuario cadastrado com sucesso\"}")
                .build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UsuarioRequestDto> listar() {
        return service.listar();
    }
    @GET
    @Path("/{cpf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscar(@PathParam("cpf") String cpf) {
        UsuarioRequestDto usuario = service.buscarPorId(cpf);
        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\": \"Cliente não encontrado\"}")
                    .build();
        }
        return Response.ok(usuario).build();
    }
    @DELETE
    @Path("/{cpf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response excluir(@PathParam("cpf") String cpf) {
        UsuarioRequestDto usuario = service.buscarPorId(cpf);
        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\": \"Cliente não encontrado\"}")
                    .build();
        }
        service.deletar(cpf);
        return Response.ok("{\"message\": \"Cliente excluído com sucesso\"}").build();
    }
    @PUT
    @Path("/{cpf}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response alterar(UsuarioRequestDto produto, @PathParam("cpf") String cpf) {
        if (produto.getCpf() != null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\": \"O id não deve ser incluído no corpo da requisição\"}")
                    .build();
        }
        produto.setCpf(cpf);
        service.atualizar(produto);
        return Response.ok("{\"message\": \"Usuario atualizado com sucesso\"}").build();
    }
}