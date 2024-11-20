package br.com.luminis.service;
import br.com.luminis.dao.UsuarioDao;
import br.com.luminis.dto.UsuarioRequestDto;
import br.com.luminis.models.Usuario;
import java.util.List;
import java.util.stream.Collectors;
public class UsuarioService {
    private UsuarioDao usuarioDao = new UsuarioDao();
    public void cadastrar(UsuarioRequestDto usuarioDto){
        Usuario usuario = usuarioDto.convert(usuarioDto);
        usuarioDao.cadastrarUsuario(usuario);
    }
    public List<UsuarioRequestDto> listar(){
        List<Usuario> produtos = usuarioDao.buscarTodosUsuarios();
        return produtos.stream()
                .map(usuario -> {
                    UsuarioRequestDto usuarioDto = new UsuarioRequestDto();
                    usuarioDto.setCpf(usuario.getCpf());
                    usuarioDto.setNome(usuario.getNome());
                    usuarioDto.setSenha(usuario.getSenha());
                    usuarioDto.setEmail(usuario.getEmail());
                    return usuarioDto;
                }).collect(Collectors.toList());
    }
    public void deletar(String cpf){
        usuarioDao.deletar(cpf);
    }
    public UsuarioRequestDto buscarPorId(String cpf) {
        Usuario usuario = usuarioDao.buscarPorId(cpf);
        UsuarioRequestDto usuarioRequestDto = new UsuarioRequestDto();
        usuarioRequestDto.setCpf(usuario.getCpf());
        usuarioRequestDto.setNome(usuario.getNome());
        usuarioRequestDto.setSenha(usuario.getSenha());
        usuarioRequestDto.setEmail(usuario.getEmail());
        return usuarioRequestDto;
    }
    public void atualizar(UsuarioRequestDto produtoDto) {
        Usuario produto = produtoDto.convert(produtoDto);
        usuarioDao.alterar(produto);
    }
}
