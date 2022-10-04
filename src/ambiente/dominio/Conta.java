package ambiente.dominio;

public class Conta {
    private int numeroAgencia = 1;
    private int numeroConta;
    private double saldo = 0;
    private String nomeCliente;
    // private Cliente cliente;

  
    public Conta(int numeroConta){
        this.numeroConta = numeroConta;
    }

    public String getNomeCliente() {
        return this.nomeCliente;
    }
    
    public double getSaldo() {
        return this.saldo;
    }

    public int getNumeroAgencia() {
        return this.numeroAgencia;
    }
    
    public int getNumeroConta() {
        return this.numeroConta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


}
