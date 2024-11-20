package br.com.luminis.dto;

import br.com.luminis.models.Usuario;

public class UsuarioRequestDto {

    private int id_usu; // Alterado para int
    private String nome;
    private String senha;
    private String email;

    // Método para converter de Usuario para UsuarioRequestDto
    public static UsuarioRequestDto convertToDto(Usuario usuario) {
        UsuarioRequestDto usuarioRequestDto = new UsuarioRequestDto();

        usuarioRequestDto.setId_usu(usuario.getId_usu());
        usuarioRequestDto.setNome(usuario.getNome());
        usuarioRequestDto.setSenha(usuario.getSenha());
        usuarioRequestDto.setEmail(usuario.getEmail());

        return usuarioRequestDto;
    }

    // Método para converter de UsuarioRequestDto para Usuario
    public Usuario convertToEntity() {
        Usuario usuario = new Usuario();

        usuario.setId_usu(this.getId_usu());
        usuario.setNome(this.getNome());
        usuario.setSenha(this.getSenha());
        usuario.setEmail(this.getEmail());

        return usuario;
    }

    // Getters e Setters
    public int getId_usu() {
        return id_usu;
    }

    public void setId_usu(int id_usu) {
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

    @Override
    public String toString() {
        return "UsuarioRequestDto{" +
                "id_usu=" + id_usu +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}