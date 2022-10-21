package ambiente.dominio;

import java.util.List;
import javax.swing.JOptionPane;

public abstract class Conta {
    private int numeroAgencia;
    private int numeroConta;
    private double saldo;
    private String Type;
    private double cheque_especial = 3000;

    public Conta(int numConta, String tipo) {
        this.numeroConta = numConta;
        this.Type = tipo;
    }

    public Conta(int numeroAgencia, int numeroConta, float saldo, String type) {
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

    public String getType() {
        return this.Type;
    }

    public double getcheque_especial() {
        return cheque_especial;
    }

    public void setcheque_especial(double cheque) {
        this.cheque_especial = cheque;
    }

    public abstract void trasferir(String CPF, int numConta, List<Cliente> clientes);

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
                            JOptionPane.showMessageDialog(null, "Saldo Insuficiente!");
                        }
                    }
                }
            }
        }
    }

    public void depositar(String CPF, int numConta, List<Cliente> clientes) {
 
        String deposito = JOptionPane.showInputDialog(null, "Qual valor deseja depositar?");

        Double valorDep = Double.parseDouble(deposito);

        for (Cliente cliente : clientes) {
            // Autenticando o cliente que será acessado
            if (CPF.equals(cliente.getCPF())) {

                for (Conta conta : cliente.getContas()) {
                    // Autenticando a conta que será acessada
                    if (numConta == conta.getNumeroConta()) {
                        conta.setSaldo(conta.getSaldo() + valorDep);
                        JOptionPane.showMessageDialog(null, "Valor de " + valorDep + " depositado com sucesso!");
                    }
                }
            }
        }

    }

}