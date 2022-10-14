package ambiente.dominio;

public class Endereco {
    private String Logradouro;
    private long numero;
    private String bairro;
    private String cidade;
    private long CEP;
    private String id_endereco;

    public Endereco(String logra, long nume, String bairro, String cida,long cep,String id){
        this.Logradouro = logra;
        this.numero = nume;
        this.cidade = cida;
        this.bairro = bairro;
        this.CEP = cep;
        this.id_endereco = id;
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
    public String getid(){
        return id_endereco;
    }
}
