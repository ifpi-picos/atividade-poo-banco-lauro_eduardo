package ambiente.dominio;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;;

public class Cliente {
    private String CPF;
    private String nome;
    private String email;
    private long telefone;
    private Date dataNascimento;
    private Endereco endereco;
    private List<Conta> contas = new ArrayList<>();
    private List<ContaCorrente> contasCor = new ArrayList<>();
    private List<ContaPoupanca> contasPop = new ArrayList<>();
    private String senha;

    public Cliente(String nome, String cpf, String email, long telefone, Endereco endereco, Date dataNascimento, /* Conta conta, */ String senha){
        this.nome = nome;
        this.CPF = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public String getEmail() {
        return email;
    }

    public long getTelefone() {
        return telefone;
    }

    // Listas de Contas
    public List<Conta> getContas() {
        return contas;
    }

    public List<ContaCorrente> getContasCor() {
        return contasCor;
    }

    public List<ContaPoupanca> getContasPop() {
        return contasPop;
    }

    public void addConta(Conta conta){
        this.contas.add(conta);
    }

    public void addContaCor(ContaCorrente conta){
        this.contasCor.add(conta);
    }

    public void addContaPop(ContaPoupanca conta){
        this.contasPop.add(conta);
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getSenha() {
        return senha;
    }
}
