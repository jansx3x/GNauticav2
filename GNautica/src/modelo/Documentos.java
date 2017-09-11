
package modelo;

/**
 *
 * @author Zetsubou (Leidjane)
 * data: 31/08/2017
 */
public class Documentos {
    private int idDoc;
    private String tipoDoc;
    private String condicao;
<<<<<<< HEAD
=======
    private Aluno idAluno;
>>>>>>> master
    
    public int getId(){
        return idDoc;
    }
    public void setIdDocumento(int idDoc){
        this.idDoc = idDoc;
    }
    public String getTipoDoc(){
        return tipoDoc;
    }
    public void setTipoDoc(String tipoDoc){
        this.tipoDoc = tipoDoc;
    }
    public String getCondicao(){
        return condicao;
    }
    public void setCondicao(String condicao){
        this.condicao = condicao;
    }
    public Aluno getAluno(){
        return idAluno;
    }
    public void setAluno(Aluno idAluno){
        this.idAluno = idAluno;
    }
}
