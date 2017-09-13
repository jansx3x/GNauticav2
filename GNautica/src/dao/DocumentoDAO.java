package dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Documentos;
import factory.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Gwynbleidd
 */

public class DocumentoDAO {
    private final String URL = "jdbc:mysql://localhost/gnautica",
            NOME = "root", SENHA = "12345";
    
    private Connection con;
    private Statement comando;
    
    public void CadastrarDoc(Documentos documento){
        conectar();
        try{
            PreparedStatement ps = this.con.prepareStatement("INSERT INTO Documentos(tipo, condicao, Aluno_idAluno)"
                    + " VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, documento.getTipoDoc());
            ps.setString(2, documento.getCondicao());
            ps.setInt(3, documento.getAluno().getIdAluno());
            ps.executeUpdate();
                
            ResultSet rs = ps.getGeneratedKeys();
            int idDoc = 0;
            if(rs.next()){
                idDoc = rs.getInt(1);
            }            
            System.out.println("Documento cadastrado!");
        } catch(SQLException e){
            imprimeErro("Erro ao cadastrar documento!", e.getMessage());
        } finally {
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
