package dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Aula;
import factory.ConnectionFactory;

/**
 *
 * @author Gwynbleidd
 */

public class AulaDAO {
    private final String URL = "jdbc:mysql://localhost/gnautica",
            NOME = "root", SENHA = "3991";
    
    private Connection con;
    private Statement comando;
    
    public void Agendar(Aula aula){
        conectar();
        try{
            comando.executeUpdate("INSERT INTO Aula VALUES("
                    + aula.getData() + "," + aula.getLocal() + ","
                    + aula.getHorario() + "," + aula.getTipoAula() + ")");
            System.out.println("Aula agendada!");
        } catch(SQLException e){
            imprimeErro("Erro ao agendar a aula!", e.getMessage());
        } finally {
            fechar();
        }
    }
    
    public void Alterar(Aula aula){
        conectar();
        String com = "UPDATE Aula SET data = " + aula.getData()
                + ", local = " + aula.getLocal() + ", horario = " + aula.getHorario()
                + ", tipoAula = " + aula.getTipoAula() + "WHERE idAula = " + aula.getId() + ";";
        System.out.println("Alteração realizada!");
        try{
            comando.executeUpdate(com);
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            fechar();
        }
    }
    
    public void Excluir(int idAula){
        conectar();
        try{
            comando.executeUpdate("DELETE FROM Aula WHERE idAula = " + idAula + ";");
        } catch(SQLException e){
            imprimeErro("Erro ao apagar aula!", e.getMessage());
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