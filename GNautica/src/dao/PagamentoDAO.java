package dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Pagamento;
import factory.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Gwynbleidd
 */

public class PagamentoDAO {
    private final String URL = "jdbc:mysql://localhost/gnautica",
            NOME = "root", SENHA = "3991";
    
    private Connection con;
    private Statement comando;
    
    public void Registrar(Pagamento pagamento){
        conectar();
        try{
            PreparedStatement ps = this.con.prepareStatement("INSERT INTO Pagamento(taxa, carteira, tipo, situacao, Aluno_idAluno)"
                    + " VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, pagamento.getTaxa());
            ps.setDouble(2, pagamento.getCarteira());
            ps.setString(3, pagamento.getTipoPag());
            ps.setString(1, pagamento.getSituacao());
            ps.setInt(3, pagamento.getAluno().getIdAluno());
            ps.executeUpdate();
                
            ResultSet rs = ps.getGeneratedKeys();
            int idPag = 0;
            if(rs.next()){
                idPag = rs.getInt(1);
            }
            System.out.println("Pagamento registrado!");
        } catch(SQLException e){
            imprimeErro("Erro ao cadastrar aluno!", e.getMessage());
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
