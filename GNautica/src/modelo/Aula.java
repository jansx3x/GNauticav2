
package modelo;

import java.util.Calendar;


/**
 *
 * @author Zetsubou (Leidjane)
 * data: 31/08/2017
 */
public class Aula {
    int id;
    Calendar data;
    String local;
    Calendar horario;
    String tipo;
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
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
    public Calendar getHorario(){
        return horario;
    }
    public void setHorario(Calendar horario){
        this.horario = horario;
    }
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
}
