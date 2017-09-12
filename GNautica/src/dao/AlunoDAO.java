package dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.Aluno;
import factory.ConnectionFactory;

/**
 *
 * @author Gwynbleidd
 */

public class AlunoDAO {
    private final String URL = "jdbc:mysql://localhost/gnautica",
            NOME = "root", SENHA = "3991";
    
    private Connection con;
    private Statement comando;
    
    public void Cadastrar(Aluno aluno){
        conectar();
        try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO Aluno(nomeAluno, CPF, endereco, telefone, email, categoria, pendencia, avaliacao)"
                    + " VALUES(?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getCpf());
            ps.setString(3, aluno.getEndereco());
            ps.setString(4, aluno.getTelefone());
            ps.setString(5, aluno.getEmail());
            ps.setString(6, aluno.getCategoria());
            ps.setString(7, aluno.getPendencia());
            ps.setString(8, aluno.getAvaliacao());
            ps.executeUpdate();
                
            ResultSet rs = ps.getGeneratedKeys();
            int idAluno = 0;
            if(rs.next()){
                idAluno = rs.getInt(1);
            }            
            System.out.println("Aluno cadastrado!");
        } catch(SQLException e){
            imprimeErro("Erro ao cadastrar aluno!", e.getMessage());
        } finally {
            fechar();
        }
    }
    
    public void Alterar(Aluno aluno){
        conectar();
        String com = "UPDATE Aluno SET nome = " + aluno.getNome()
                + ", CPF = " + aluno.getCpf() + ", endereco = " + aluno.getEndereco()
                + ", telefone = " + aluno.getTelefone() + ", email = " + aluno.getEmail()
                + ", categoria = " + aluno.getCategoria() + ", pendencia = " + aluno.getPendencia()
                + ", avaliacao = " + aluno.getAvaliacao() + " WHERE idAluno = " + aluno.getIdAluno() + ";";
        System.out.println("Alteração realizada!");
        try{
            comando.executeUpdate(com);
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            fechar();
        }
    }
    
    public void Excluir(int idAluno){
        conectar();
        try{
            comando.executeUpdate("DELETE FROM Aluno WHERE idAluno = " + idAluno + ";");
        } catch(SQLException e){
            imprimeErro("Erro ao apagar aluno!", e.getMessage());
        } finally{
            fechar();
        }
    }
    
    
    private void conectar(){
        try{
            con = ConnectionFactory.conexao(URL, NOME, SENHA, ConnectionFactory.MYSQL);
            comando = con.createStatement();
            System.out.println("Conectado!");
        } catch(ClassNotFoundException e){
            imprimeErro("Erro ao carregar o driver!", e.getMessage());
        } catch(SQLException e){
            imprimeErro("Erro ao conectar!", e.getMessage());
        }
    }
    
    private void fechar(){
        try{
            comando.close();
            con.close();
            System.out.println("Conexão Fechada!");
        } catch(SQLException e){
            imprimeErro("Erro ao fechar conexão!", e.getMessage());
        }
    }
    
    private void imprimeErro(String msg, String msgErro){
        JOptionPane.showMessageDialog(null, msg, "Erro crítico", 0);
        System.err.println(msg);
        System.out.println(msgErro);
        System.exit(0);
    }
}