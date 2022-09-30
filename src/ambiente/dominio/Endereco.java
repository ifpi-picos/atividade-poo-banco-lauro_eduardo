package ambiente.dominio;

public class Endereco {
    private String Logradouro;
    private int numero;
    private String bairro;
    private String cidade;
    private int CEP;

    public Endereco(String logra, int nume, String bairro, String cida,int cep){
        this.Logradouro = logra;
        this.numero = nume;
        this.cidade = cida;
        this.bairro = bairro;
        this.CEP = cep;
    }
}
