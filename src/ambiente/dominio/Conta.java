package ambiente.dominio;

public class Conta {
    private int numeroAgencia;
    private int numeroConta;
    private double saldo;
    private String Type;
    private double cheque_especial = 3000;
    private int numTransf = 0;


    public Conta(int numConta, String tipo){
        this.numeroConta = numConta;
        this.Type = tipo;
    }
  
    public Conta(int numeroAgencia, int numeroConta, float saldo, String type){
        this.numeroAgencia = 1;
        this.numeroConta = numeroConta;
        this.saldo = 0;
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
    public double getcheque_especial(){
        return cheque_especial;
    }
    public void setcheque_especial(double cheque){
        this.cheque_especial = cheque;
    }

    public int getNumTransf() {
        return numTransf;
    }

    public void setNumTransf(int numTransf) {
        this.numTransf = numTransf;
    }


}
