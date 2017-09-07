package dao;
import factory.ConnectionFactory;
import modelo.Aluno;
import java.sql.*;
import java.sql.PreparedStatement;

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
        
    }
}
