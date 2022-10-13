package ambiente.dominio;

public class Conta {
    private int numeroAgencia = 1;
    private int numeroConta;
    private double saldo = 0;
    private String Type;
    // private Cliente cliente;

  
    public Conta(int numeroConta, String type){
        this.numeroConta = numeroConta;
        this.Type = type;
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
    public String getType(){
        return this.Type;
    }


}
