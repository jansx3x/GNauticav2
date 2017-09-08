
package modelo;

/**
 *
 * @author Zetsubou (Leidjane)
 * data: 31/08/2017
 */
public class Gastos {
    private int idGasto;
    private String tipoGasto;
    private double valor;
    
    public int getIdGasto(){
        return idGasto;
    }
    public void setIdGasto(int idGasto){
        this.idGasto = idGasto;
    }
    public String getTipoGasto(){
        return tipoGasto;
    }
    public void setTipoGasto(String tipoGasto){
        this.tipoGasto = tipoGasto;
    }
    public double getValor(){
        return valor;
    }
    public void setValor(double valor){
        this.valor = valor;
    }
}
