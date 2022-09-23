package ambiente.dominio;

import java.util.Date;
import java.util.List;

public class Cliente {
    private String nome;
    private int CPF;
    private Date dataNascimento;
    private String endereco;
    private List<Conta> contas;

    

    public String getNome() {
        return nome;
    }

    public int getCPF() {
        return CPF;
    }

    public List getContas() {
        return contas;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }
}
