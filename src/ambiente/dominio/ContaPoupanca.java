package ambiente.dominio;

public class ContaPoupanca extends Conta{

    
    public ContaPoupanca(int numeroAgencia, int numeroConta, float saldo, String Type){
        super(numeroAgencia, numeroConta, saldo, Type);

    }

    public ContaPoupanca(int numConta, String Type){
        super(numConta, Type);
    }
    
}
