package modelo;

/**
 *
 * @author Zetsubou (Leidjane)
 * data: 31/08/2017
 */
public class Aluno {
    String nome;
    String cpf;
    String endereco;
    String telefone;
    String email;
    String categoria;
    String pendencia;
    String avaliacao;
    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public String getCategoria(){
        return categoria;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    public String getPendencia(){
        return pendencia;
    }
    public void setPendencia(String pendencia){
        this.pendencia = pendencia;
    }
    public String getAvaliacao(){
        return avaliacao;
    }
    public void setAvaliacao(String avaliacao){
        this.avaliacao = avaliacao;
    }
}
