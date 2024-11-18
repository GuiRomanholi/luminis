package br.com.luminis.dto;

import br.com.luminis.models.Usuario;

public class UsuarioRequestDto {

    private String id_usu;
    private String nome;
    private String senha;
    private String email;

    public UsuarioRequestDto convertToDto(Usuario usuario){
        UsuarioRequestDto usuarioRequestDto = new UsuarioRequestDto();

        usuarioRequestDto.setId_usu(usuario.getId_usu());
        usuarioRequestDto.setNome(usuario.getNome());
        usuarioRequestDto.setSenha(usuario.getSenha());
        usuarioRequestDto.setEmail(usuario.getEmail());
        return usuarioRequestDto;
    }

    public Usuario convert(UsuarioRequestDto usuarioRequestDto) {
        Usuario usuario = new Usuario();
        usuario.setId_usu(usuarioRequestDto.getId_usu());
        usuario.setNome(usuarioRequestDto.getNome());
        usuario.setSenha(usuarioRequestDto.getSenha());
        usuario.setEmail(usuarioRequestDto.getEmail());
        return usuario;
    }

    //Getters e Setters
    public String getId_usu() {
        return id_usu;
    }

    public void setId_usu(String id_usu) {
        this.id_usu = id_usu;
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
