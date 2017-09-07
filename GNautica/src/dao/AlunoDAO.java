package dao;
import factory.ConnectionFactory;
import modelo.Aluno;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gwynbleidd
 */

public class AlunoDAO {
    private Connection connection;
    int idAluno;
    String nome;
    String cpf;
    String endereco;
    String telefone;
    String email;
    String categoria;
    String pendencia;
    String avaliacao;
    
    public AlunoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void Adiciona(Aluno aluno){
        String sql = "INSERT INTO Aluno(nome,cpf,endereco,telefone,email,categoria,pendencia,avaliacao) VALUES(?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1,aluno.getNome());
            stmt.setString(2,aluno.getCpf());
            stmt.setString(3,aluno.getEndereco());
            stmt.setString(4,aluno.getTelefone());
            stmt.setString(5,aluno.getEmail());
            stmt.setString(6,aluno.getCategoria());
            stmt.setString(7,aluno.getPendencia());
            stmt.setString(8,aluno.getAvaliacao());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
