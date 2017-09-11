package dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Gastos;
import factory.ConnectionFactory;

/**
 *
 * @author Gwynbleidd
 */

public class GastosDAO {
    private final String URL = "jdbc:mysql://localhost/gnautica",
            NOME = "root", SENHA = "3991";
    
    private Connection con;
    private Statement comando;
    
    public void RegistrarGasto(Gastos gasto){
        conectar();
        try{
            comando.executeUpdate("INSERT INTO Aluno VALUES("
                    + gasto.getTipoGasto() + "," + gasto.getValor() + ","
                    + gasto.getAula().getId() + ")");
            System.out.println("Gasto registrado!");
        } catch(SQLException e){
            imprimeErro("Erro ao registrar gasto!", e.getMessage());
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
