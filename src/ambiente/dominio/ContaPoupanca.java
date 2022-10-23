package ambiente.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(int numeroAgencia, int numeroConta, float saldo, String Type) {
        super(numeroAgencia, numeroConta, saldo, Type);

    }

    public ContaPoupanca(int numConta, String Type) {
        super(numConta, Type);
    }

    @Override
    public void trasferir(String CPF, int numConta, List<Cliente> clientes) {

        String transferencia = JOptionPane.showInputDialog(null, "Qual valor deseja transferir?");
        String pesDestino = JOptionPane.showInputDialog(null, "Qual o CPF do destinatário?");
        String numDestino = JOptionPane.showInputDialog(null, "Qual o número da conta do destinatário?");
        Double valorTransf = Double.parseDouble(transferencia);
        Double taxaTransfPop = valorTransf * 0.05;
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
                                System.out.println("6");
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

                                                    conta.setSaldo(conta.getSaldo() - (valorTransf + taxaTransfPop));
                                                    JOptionPane.showMessageDialog(null,
                                                            "Valor de " + (valorTransf) + " transferido com sucesso!");

                                                    cont.setSaldo(cont.getSaldo() + (valorTransf));
                                                    String e = cliente.getEmail();
                                                    Long n = cliente.getTelefone();
                                                    String operacao = "transferência";
                                                    Email email = new Email();
                                                    email.enviarnotificacao(operacao, valorTransf,e,n);
                                                    Sms sms = new Sms();
                                                    sms.enviarnotificacao(operacao, valorTransf,e,n);

                                                    break;

                                                }

                                            }
                                        }
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "O CPF que você digitou está inválido!");
                                // CPF da pessoa que vai enviar
                            }
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Saldo insuficiente!");
                            // Se o valor da transferência for menor
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
                            String e = cliente.getEmail();
                            Long n = cliente.getTelefone();
                            String operacao = "o saque";
                            Email email = new Email();
                            email.enviarnotificacao(operacao, valorSaque,e,n);
                            Sms sms = new Sms();
                            sms.enviarnotificacao(operacao, valorSaque,e,n);
                        } else {
                            JOptionPane.showMessageDialog(null, "Saldo Insuficiente!");
                        }
                    }
                }
            }
        }
    }

}
