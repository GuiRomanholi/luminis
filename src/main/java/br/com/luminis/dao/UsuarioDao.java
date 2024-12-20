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
    public void cadastrarUsuario(Usuario usuario){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;
        try {
            String sql = "insert into usuario( cpf, nome, senha, email) values (?,?,?,?)";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setString(1, usuario.getCpf());
            comandoSql.setString(2, usuario.getNome());
            comandoSql.setString(3, usuario.getSenha());
            comandoSql.setString(4, usuario.getEmail());
            comandoSql.executeUpdate();
            comandoSql.close();
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
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
                usuario.setCpf(rs.getString(1));
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
    public Usuario buscarPorId(String cpf){
        Usuario usuario = new Usuario();
        PreparedStatement comandoSql = null;
        conexao = ConnectionFactory.obterConexao();
        try {
            comandoSql = conexao.prepareStatement("SELECT * FROM usuario WHERE cpf = ?");
            comandoSql.setString(1, cpf);
            ResultSet rs = comandoSql.executeQuery();
            if (rs.next()) {
                usuario.setCpf(rs.getString(1));
                usuario.setNome(rs.getString(2));
                usuario.setSenha(rs.getString(3));
                usuario.setEmail(rs.getString(4));
            }
            conexao.close();
            comandoSql.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
    public void deletar( String cpf){
        Connection conexao = null;
        PreparedStatement comandoSql = null;
        try {
            conexao = ConnectionFactory.obterConexao();
            conexao.setAutoCommit(false);
            String sqlDeleteUsuario = "DELETE FROM usuario WHERE cpf = ?";
            comandoSql = conexao.prepareStatement(sqlDeleteUsuario);
            comandoSql.setString(1, cpf);
            comandoSql.executeUpdate();
            conexao.commit();
        } catch (SQLException e) {
            if (conexao != null) {
                try {
                    conexao.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            throw new RuntimeException("Erro ao deletar usuario: " + e.getMessage(), e);
        } finally {
            try {
                if (comandoSql != null) {
                    comandoSql.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void alterar(Usuario usuario){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql;
        try {
            String sql = "UPDATE usuario SET nome = ?, senha = ?, email = ? WHERE cpf = ?";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setString(1, usuario.getNome());
            comandoSql.setString(2, usuario.getSenha());
            comandoSql.setString(3, usuario.getEmail());
            comandoSql.setString(4, usuario.getCpf());
            comandoSql.executeUpdate();
            comandoSql.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
