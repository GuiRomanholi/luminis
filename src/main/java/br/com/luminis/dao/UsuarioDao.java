package br.com.luminis.dao;

import br.com.luminis.models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    private Connection conexao;

    public void cadastrarUsuario(Usuario usuario) {
        conexao = ConnectionFactory.obterConexao();

        String sql = "INSERT INTO usuario (nome, senha, email) VALUES (?, ?, ?)";

        try (PreparedStatement comandoSql = conexao.prepareStatement(sql)) {
            comandoSql.setString(1, usuario.getNome());
            comandoSql.setString(2, usuario.getSenha());
            comandoSql.setString(3, usuario.getEmail());

            comandoSql.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao cadastrar usuário: " + e.getMessage(), e);
        } finally {
            try {
                if (conexao != null && !conexao.isClosed()) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Usuario> buscarTodosUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        PreparedStatement comandoSql = null;
        conexao = ConnectionFactory.obterConexao();
        try{
            comandoSql = conexao.prepareStatement("Select * from usuario");
            ResultSet rs = comandoSql.executeQuery();
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId_usu(rs.getInt(1));
                usuario.setNome(rs.getString(2));
                usuario.setSenha(rs.getString(3));
                usuario.setEmail(rs.getString(4));

                usuarios.add(usuario);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return usuarios;
    }

    public Usuario buscarPorId(int id) {
        Usuario usuario = null;
        String sql = "SELECT id_usu, nome, senha, email FROM usuario WHERE id_usu = ?";

        try (Connection conexao = ConnectionFactory.obterConexao();
             PreparedStatement comandoSql = conexao.prepareStatement(sql)) {

            comandoSql.setInt(1, id);
            ResultSet resultado = comandoSql.executeQuery();

            if (resultado.next()) {
                usuario = new Usuario();
                usuario.setId_usu(resultado.getInt("id_usu"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setEmail(resultado.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public void deletar(int id) {
        String sql = "DELETE FROM usuario WHERE id_usu = ?";

        try (Connection conexao = ConnectionFactory.obterConexao();
             PreparedStatement comandoSql = conexao.prepareStatement(sql)) {

            comandoSql.setInt(1, id);
            comandoSql.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterar(Usuario usuario) {
        String sql = "UPDATE usuario SET nome = ?, senha = ?, email = ? WHERE id_usu = ?";

        try (Connection conexao = ConnectionFactory.obterConexao();
             PreparedStatement comandoSql = conexao.prepareStatement(sql)) {

            comandoSql.setString(1, usuario.getNome());
            comandoSql.setString(2, usuario.getSenha());
            comandoSql.setString(3, usuario.getEmail());
            comandoSql.setInt(4, usuario.getId_usu());

            comandoSql.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
