package ambiente.dominio;

public class Endereco {
    private String Logradouro;
    private long numero;
    private String bairro;
    private String cidade;
    private long CEP;

    public Endereco(String logra, long nume, String bairro, String cida,long cep){
        this.Logradouro = logra;
        this.numero = nume;
        this.cidade = cida;
        this.bairro = bairro;
        this.CEP = cep;
    }

    public String getLogra(){
        return Logradouro;
    }

    public long getNume(){
        return numero;
    }

    public String getBairro(){
        return bairro;
    }

    public String getCidade(){
        return cidade;
    }

    public long getCEP(){
        return CEP;
    }
}
