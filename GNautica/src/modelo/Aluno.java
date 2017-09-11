package modelo;

/**
 *
 * @author Zetsubou (Leidjane)
 * data: 31/08/2017
 */
public class Aluno {
    private int idAluno;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String email;
    private String categoria;
    private String pendencia;
    private String avaliacao;
    private Aula idAula;
    
    public int getIdAluno(){
        return idAluno;
    }
    public void setIdAluno(int idAluno){
        this.idAluno = idAluno;
    }
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
    public Aula getAula(){
        return idAula;
    }
    public void setAula(Aula idAula){
        this.idAula = idAula;
    }
}
