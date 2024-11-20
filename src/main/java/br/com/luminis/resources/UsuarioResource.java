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
        builder.path(String.valueOf(usuario.getId_usu()));

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
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscar(@PathParam("id") int id) {
        UsuarioRequestDto usuario = service.buscarPorId(id);
        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\": \"Cliente não encontrado\"}")
                    .build();
        }
        return Response.ok(usuario).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response excluir(@PathParam("id") int id) {
        UsuarioRequestDto usuario = service.buscarPorId(id);
        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\": \"Cliente não encontrado\"}")
                    .build();
        }
        service.deletar(id);
        return Response.ok("{\"message\": \"Cliente excluído com sucesso\"}").build();
    }


    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response alterar(@PathParam("id") int id, UsuarioRequestDto usuarioDto) {
        usuarioDto.setId_usu(Integer.parseInt(String.valueOf(id)));

        service.atualizar(usuarioDto);

        return Response.ok("{\"message\": \"Usuário atualizado com sucesso\"}")
                .build();
    }

}
