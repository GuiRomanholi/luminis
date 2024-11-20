package br.com.luminis.service;

import br.com.luminis.dao.UsuarioDao;
import br.com.luminis.dto.UsuarioRequestDto;
import br.com.luminis.models.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioService {

    private UsuarioDao usuarioDao = new UsuarioDao();

    public void cadastrar(UsuarioRequestDto usuarioDto) {
        Usuario usuario = usuarioDto.convertToEntity();
        usuarioDao.cadastrarUsuario(usuario);
    }

    public List<UsuarioRequestDto> listar(){
        List<Usuario> produtos = usuarioDao.buscarTodosUsuarios();
        return produtos.stream()
                .map(usuario -> {
                    UsuarioRequestDto usuarioDto = new UsuarioRequestDto();
                    usuarioDto.setId_usu(usuario.getId_usu());
                    usuarioDto.setNome(usuario.getNome());
                    usuarioDto.setSenha(usuario.getSenha());
                    usuarioDto.setEmail(usuario.getEmail());
                    return usuarioDto;
                }).collect(Collectors.toList());
    }

    public void deletar(int id){
        usuarioDao.deletar(id);
    }

    public UsuarioRequestDto buscarPorId(int id) {
        Usuario usuario = usuarioDao.buscarPorId(id);
        UsuarioRequestDto usuarioRequestDto = new UsuarioRequestDto();
        usuarioRequestDto.setId_usu(usuario.getId_usu());
        usuarioRequestDto.setNome(usuario.getNome());
        usuarioRequestDto.setSenha(usuario.getSenha());
        usuarioRequestDto.setEmail(usuario.getEmail());
        return usuarioRequestDto;
    }

    public void atualizar(UsuarioRequestDto produtoDto) {
        Usuario produto = produtoDto.convertToEntity();
        usuarioDao.alterar(produto);
    }
}
