
package modelo;

import java.util.Calendar;
/**
 *
 * @author Zetsubou (Leidjane)
 * data: 31/08/2017
 */
public class Aula {
    private int idAula;
    private Calendar data;
    private String local;
    private String horario;
    private String tipoAula;
    public int getId(){
        return idAula;
    }
    public void setId(int idAula){
        this.idAula = idAula;
    }
    public Calendar getData(){
        return data;
    }
    public void setData(Calendar data){
        this.data = data;
    }
    public String getLocal(){
        return local;
    }
    public void setLocal(String local){
        this.local = local;
    }
    public String getHorario(){
        return horario;
    }
    public void setHorario(String horario){
        this.horario = horario;
    }
    public String getTipoAula(){
        return tipoAula;
    }
    public void setTipoAula(String tipoAula){
        this.tipoAula = tipoAula;
    }
}
