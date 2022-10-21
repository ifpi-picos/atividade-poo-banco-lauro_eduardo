package ambiente.dominio;

public class ContaCorrente extends Conta{
    private int numTransf = 0;
    private double cheque_especial = 3000;

    public ContaCorrente(int numeroAgencia, int numeroConta, float saldo, String Type){
        super(numeroAgencia, numeroConta, saldo, Type);

    }

    public ContaCorrente(int numConta, String Type){
        super(numConta, Type);
    }
    
}
