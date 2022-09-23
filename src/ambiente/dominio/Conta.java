package ambiente.dominio;

public class Conta {
    private int numeroAgencia;
    private int numeroConta;
    private int saldo;
    private String nomeCliente;
    private Cliente cliente;



    public String getNomeCliente() {
        return nomeCliente;
    }
    
    public int getSaldo() {
        return saldo;
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }
    
    public int getNumeroConta() {
        return numeroConta;
    }
}
