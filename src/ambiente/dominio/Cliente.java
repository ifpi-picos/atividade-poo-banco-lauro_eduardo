package ambiente.dominio;

import java.util.Date;
import java.util.List;

public class Cliente {
    public final String CPF;
    private String nome;
    private Date dataNascimento;
    private Endereco endereco;
    private List<Conta> contas;

    public Cliente(String nome, String cpf, Endereco Endereco/*, Date data */){
        this.nome = nome;
        this.CPF = cpf;
        /*this.dataNascimento = data;*/
        this.endereco = Endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public List getContas() {
        return contas;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
