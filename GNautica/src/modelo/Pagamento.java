
package modelo;

/**
 *
 * @author Zetsubou (Leidjane)
 * data: 31/08/2017
 */
public class Pagamento {
    private int idPag;
    private double taxa;
    private double carteira;
    private String tipoPag;
    private String situacao;
    public int getIdPag(){
        return idPag;
    }
    public void setIdPag(int idPag){
        this.idPag = idPag;
    }
    public double getTaxa(){
        return taxa;
    }
    public void setTaxa(double taxa){
        this.taxa = taxa;
    }
    public double getCarteira(){
        return carteira;
    }
    public void setCarteira(double carteira){
        this.carteira = carteira;
    }
    public String getTipoPag(){
        return tipoPag;
    }
    public void setTipoPag(String tipoPag){
        this.tipoPag = tipoPag;
    }
    public String getSituacao(){
        return situacao;
    }
    public void setSituacao(String situacao){
        this.situacao = situacao;
    }
}
