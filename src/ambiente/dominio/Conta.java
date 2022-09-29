package ambiente.dominio;

public class Conta {
    private int numeroAgencia;
    private int numeroConta;
    private int saldo;
    private String nomeCliente;
    private Cliente cliente;



    public String getNomeCliente() {
        return this.nomeCliente;
    }
    
    public int getSaldo() {
        return this.saldo;
    }

    public int getNumeroAgencia() {
        return this.numeroAgencia;
    }
    
    public int getNumeroConta() {
        return this.numeroConta;
    }


}
