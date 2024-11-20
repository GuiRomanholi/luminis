package br.com.luminis.dto;
import br.com.luminis.models.Usuario;
public class UsuarioRequestDto {
    private String cpf;
    private String nome;
    private String senha;
    private String email;
    public UsuarioRequestDto convertToDto(Usuario usuario){
        UsuarioRequestDto usuarioRequestDto = new UsuarioRequestDto();
        usuarioRequestDto.setCpf(usuario.getCpf());
        usuarioRequestDto.setNome(usuario.getNome());
        usuarioRequestDto.setSenha(usuario.getSenha());
        usuarioRequestDto.setEmail(usuario.getEmail());
        return usuarioRequestDto;
    }
    public Usuario convert(UsuarioRequestDto usuarioRequestDto) {
        Usuario usuario = new Usuario();
        usuario.setCpf(usuarioRequestDto.getCpf());
        usuario.setNome(usuarioRequestDto.getNome());
        usuario.setSenha(usuarioRequestDto.getSenha());
        usuario.setEmail(usuarioRequestDto.getEmail());
        return usuario;
    }
    //Getters e Setters

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}