package ambiente.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ContaCorrente extends Conta{
    private static double cheque_especial = 3000;
    private static int numTransf = 0;
    
    public ContaCorrente(int numeroAgencia, int numeroConta, float saldo, String Type){
        super(numeroAgencia, numeroConta, saldo, Type);

    }

    public ContaCorrente(int numConta, String Type){
        super(numConta, Type);
    }

    public static int getNumtrans(){
        return numTransf;
    }

    public void setNumTransf(Integer numero){
        numTransf = numero;
    }

    public static double getCheque(){
        return cheque_especial;
    }
    public static void setCheque(double cheque){
        cheque_especial = cheque;
    }
    
    @Override
    public void trasferir(String CPF, int numConta, List<Cliente> clientes){
        String transferencia = JOptionPane.showInputDialog(null, "Qual valor deseja transferir?");
        String pesDestino = JOptionPane.showInputDialog(null, "Qual o CPF do destinatário?");
        String numDestino = JOptionPane.showInputDialog(null, "Qual o número da conta do destinatário?");

        Double valorTransf = Double.parseDouble(transferencia);
        Double taxaTransfCor = valorTransf*0.10;
        Integer numConDestino = Integer.parseInt(numDestino);

        for (Cliente cliente : clientes) {
            // Autenticando o cliente que será acessado
            if (CPF.equals(cliente.getCPF())) {

                for (Conta conta : cliente.getContas()) {
                    // Autenticando a conta que será acessada
                    if (numConta == conta.getNumeroConta()) {

                        if (valorTransf <= conta.getSaldo()) {

                            List<String> cliCPF = new ArrayList<>();
                            for (Cliente c : clientes) {
                                cliCPF.add(c.getCPF());
                            }

                            if (cliCPF.contains(pesDestino)) {

                                for (Cliente cli : clientes) {
                                    // Autenticando o cliente que será acessado
                                    if (pesDestino.equals(cli.getCPF())) {

                                        List<Integer> cliConta = new ArrayList<>();

                                       for (Conta cont : cli.getContas()) {
                                            cliConta.add(cont.getNumeroConta());
                                        }

                                        if (cliConta.contains(numConDestino)) {

                                            for (Conta cont : cli.getContas()) {
                                                // Autenticando a conta que será acessada
                                                if (numConDestino == cont.getNumeroConta()) {

                                                   if(getNumtrans() >= 2){

                                                        conta.setSaldo(conta.getSaldo() - (valorTransf + taxaTransfCor));
                                                        setNumTransf(getNumtrans() + 1);
                                                        JOptionPane.showMessageDialog(null, "Valor de " + (valorTransf) + " transferido com sucesso!");

                                                        cont.setSaldo(cont.getSaldo() + (valorTransf));

                                                        break;

                                                    }else{

                                                        conta.setSaldo(conta.getSaldo() - valorTransf);
                                                        setNumTransf(getNumtrans() + 1);
                                                        JOptionPane.showMessageDialog(null, "Valor de " + valorTransf+ " transferido com sucesso!");

                                                        cont.setSaldo(cont.getSaldo() + valorTransf);

                                                        break;

                                                    }
                                                }
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Conta não existe!");
                                            break;
                                        }

                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Cliente não existe!");
                                break;
                            }
                        } else {
                            
                                List<String> cliCPF = new ArrayList<>();
                                for (Cliente c : clientes) {
                                cliCPF.add(c.getCPF());
                            }
                                if (cliCPF.contains(pesDestino)) {

                                    for (Cliente cli : clientes) {
                                    // Autenticando o cliente que será acessado

                                        if (pesDestino.equals(cli.getCPF())) {

                                        List<Integer> cliConta = new ArrayList<>();

                                        for (Conta cont : cli.getContas()) {
                                            cliConta.add(cont.getNumeroConta());
                                        }

                                            if (cliConta.contains(numConDestino)) {

                                                for (Conta cont : cli.getContas()) {
                                                // Autenticando a conta que será acessada
                                                    if (numConDestino == cont.getNumeroConta()) {

                                                        Double analise = conta.getSaldo() - (valorTransf + taxaTransfCor);

                                                        if(conta.getSaldo() > 0){
                                        
                                                            if(conta.getSaldo() + getCheque()  >= (valorTransf + taxaTransfCor)){
                                                                conta.setSaldo(conta.getSaldo() - (valorTransf + taxaTransfCor));
                                                                setCheque(getCheque() + analise);
                                                                JOptionPane.showMessageDialog(null, "Valor de " + (valorTransf) + " transferido com sucesso!");

                                                                cont.setSaldo(cont.getSaldo() + (valorTransf));

                                                                break;

                                                            }else{
                                                                JOptionPane.showMessageDialog(null, "O valor ultrapassa o saldo da sua conta com o cheque!");
                                                            }
                                                        }else{
                                                            if(getCheque() >= (valorTransf + taxaTransfCor)){
                                                                conta.setSaldo(conta.getSaldo() - (valorTransf + taxaTransfCor));
                                                                setCheque(getCheque() + analise);
                                                                JOptionPane.showMessageDialog(null, "Valor de " + valorTransf + " transferido com sucesso!");

                                                                cont.setSaldo(cont.getSaldo() + valorTransf);

                                                                break;
                                                            }else{
                                                                JOptionPane.showMessageDialog(null, "O valor ultrapassa o saldo do cheque!");
                                                            }
                                                        }

                                                }
                                            }

                                        }else{
                                            JOptionPane.showMessageDialog(null, "Conta não existe!");
                                            break;
                                        }

                                    }
                                }

                            }else {
                                JOptionPane.showMessageDialog(null, "Cliente não existe!");
                                break;
                            }

                        
                        
                    }
                    }
                }
            }
        }
    }
    
    @Override
    public void sacar(String CPF, int numConta, List<Cliente> clientes) {
        String saque = JOptionPane.showInputDialog(null, "Qual valor deseja sacar?");

        Double valorSaque = Double.parseDouble(saque);

        for (Cliente cliente : clientes) {
            // Autenticando o cliente que será acessado
            if (CPF.equals(cliente.getCPF())) {

                for (Conta conta : cliente.getContas()) {
                    // Autenticando a conta que será acessada
                    if (numConta == conta.getNumeroConta()) {

                        Double analise = conta.getSaldo() - valorSaque;
                        if (analise >= 0) {
                            conta.setSaldo(conta.getSaldo() - valorSaque);
                            JOptionPane.showMessageDialog(null, "Valor de " + valorSaque + " sacado com sucesso!");
                        } else {
                            if (conta.getSaldo() > 0) {
                                /* if (conta.getcheque_especial() + conta.getSaldo() >= valorSaque) {
                                    conta.setSaldo(conta.getSaldo() - valorSaque);
                                    conta.setcheque_especial(conta.getcheque_especial() + analise);
                                    JOptionPane.showMessageDialog(null, "Valor de " + valorSaque
                                            + " sacado com sucesso! Usamos o cheque especial!");
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "O valor ultrapassa o saldo da sua conta com o cheque!");
                                } */
                                if (getCheque() + conta.getSaldo() >= valorSaque) {
                                    conta.setSaldo(conta.getSaldo() - valorSaque);
                                    setCheque(getCheque() + analise);
                                    JOptionPane.showMessageDialog(null, "Valor de " + valorSaque
                                            + " sacado com sucesso! Usamos o cheque especial!");
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "O valor ultrapassa o saldo da sua conta com o cheque!");
                                }
                            } else {
                                /* if (conta.getcheque_especial() >= valorSaque) {
                                    conta.setSaldo(conta.getSaldo() - valorSaque);
                                    conta.setcheque_especial(conta.getcheque_especial() + analise);
                                    JOptionPane.showMessageDialog(null, "Valor de " + valorSaque
                                            + " sacado com sucesso! Usamos o cheque especial!");
                                } else {
                                    JOptionPane.showMessageDialog(null, "O valor ultrapassa o saldo do cheque!");
                                } */
                                if (getCheque() >= valorSaque) {
                                    conta.setSaldo(conta.getSaldo() - valorSaque);
                                    setCheque(getCheque() + analise);
                                    JOptionPane.showMessageDialog(null, "Valor de " + valorSaque
                                            + " sacado com sucesso! Usamos o cheque especial!");
                                } else {
                                    JOptionPane.showMessageDialog(null, "O valor ultrapassa o saldo do cheque!");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
