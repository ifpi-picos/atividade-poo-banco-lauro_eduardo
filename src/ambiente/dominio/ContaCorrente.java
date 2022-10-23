package ambiente.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ContaCorrente extends Conta {
    private double cheque_especial = 3000;
    private int numTransf = 0;

    public ContaCorrente(int numeroAgencia, int numeroConta, float saldo, String Type) {
        super(numeroAgencia, numeroConta, saldo, Type);

    }

    public ContaCorrente(int numConta, String Type) {
        super(numConta, Type);
    }

    public int getNumtrans() {
        return numTransf;
    }

    public void setNumTransf(Integer numero) {
        numTransf = numero;
    }

    public double getCheque() {
        return cheque_especial;
    }

    public void setCheque(double cheque) {
        cheque_especial = cheque;
    }

    @Override
    public void trasferir(String CPF, int numConta, List<Cliente> clientes) {
        System.out.println(getCheque());
        String transferencia = JOptionPane.showInputDialog(null, "Qual valor deseja transferir?");
        String pesDestino = JOptionPane.showInputDialog(null, "Qual o CPF do destinatário?");
        String numDestino = JOptionPane.showInputDialog(null, "Qual o número da conta do destinatário?");

        Double valorTransf = Double.parseDouble(transferencia);
        Double taxaTransfCor = valorTransf * 0.10;
        Integer numConDestino = Integer.parseInt(numDestino);

        for (Cliente cliente : clientes) {
            // Autenticando o cliente que será acessado
            if (CPF.equals(cliente.getCPF())) {

                for (ContaCorrente conta : cliente.getContasCor()) {
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

                                                    if (conta.getNumtrans() >= 2) {

                                                        conta.setSaldo(
                                                                conta.getSaldo() - (valorTransf + taxaTransfCor));
                                                        conta.setNumTransf(conta.getNumtrans() + 1);
                                                        JOptionPane.showMessageDialog(null, "Valor de " + (valorTransf)
                                                                + " transferido com sucesso!");

                                                        cont.setSaldo(cont.getSaldo() + (valorTransf));
                                                        String e = cliente.getEmail();
                                                        Long n = cliente.getTelefone();
                                                        String operacao = "a traferência";
                                                        Email email = new Email();
                                                        email.enviarnotificacao(operacao, valorTransf, e, n);
                                                        Sms sms = new Sms();
                                                        sms.enviarnotificacao(operacao, valorTransf, e, n);

                                                        break;

                                                    } else {

                                                        conta.setSaldo(conta.getSaldo() - valorTransf);
                                                        setNumTransf(getNumtrans() + 1);
                                                        JOptionPane.showMessageDialog(null, "Valor de " + valorTransf
                                                                + " transferido com sucesso!");

                                                        cont.setSaldo(cont.getSaldo() + valorTransf);
                                                        String e = cliente.getEmail();
                                                        Long n = cliente.getTelefone();
                                                        String operacao = "a traferência";
                                                        Email email = new Email();
                                                        email.enviarnotificacao(operacao, valorTransf, e, n);
                                                        Sms sms = new Sms();
                                                        sms.enviarnotificacao(operacao, valorTransf, e, n);

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

                                                    if (conta.getNumtrans() >= 2) {

                                                        Double analise = conta.getSaldo()
                                                                - (valorTransf + taxaTransfCor);

                                                        if (conta.getSaldo() > 0) {

                                                            if (conta.getSaldo()
                                                                    + conta.getCheque() >= (valorTransf
                                                                            + taxaTransfCor)) {
                                                                conta.setSaldo(
                                                                        conta.getSaldo()
                                                                                - (valorTransf + taxaTransfCor));
                                                                conta.setCheque(conta.getCheque() + analise);
                                                                JOptionPane.showMessageDialog(null, "Valor de "
                                                                        + (valorTransf) + " transferido com sucesso!");

                                                                cont.setSaldo(cont.getSaldo() + (valorTransf));
                                                                String e = cliente.getEmail();
                                                                Long n = cliente.getTelefone();
                                                                String operacao = "a traferência";
                                                                Email email = new Email();
                                                                email.enviarnotificacao(operacao, valorTransf, e, n);
                                                                Sms sms = new Sms();
                                                                sms.enviarnotificacao(operacao, valorTransf, e, n);

                                                                break;

                                                            } else {
                                                                JOptionPane.showMessageDialog(null,
                                                                        "O valor ultrapassa o saldo da sua conta com o cheque!");
                                                            }
                                                        } else {
                                                            if (conta.getCheque() >= (valorTransf + taxaTransfCor)) {
                                                                conta.setSaldo(
                                                                        conta.getSaldo()
                                                                                - (valorTransf + taxaTransfCor));
                                                                conta.setCheque(conta.getCheque() + analise);
                                                                JOptionPane.showMessageDialog(null, "Valor de "
                                                                        + valorTransf + " transferido com sucesso!");

                                                                cont.setSaldo(cont.getSaldo() + valorTransf);
                                                                String e = cliente.getEmail();
                                                                Long n = cliente.getTelefone();
                                                                String operacao = "a traferência";
                                                                Email email = new Email();
                                                                email.enviarnotificacao(operacao, valorTransf, e,n);
                                                                Sms sms = new Sms();
                                                                sms.enviarnotificacao(operacao, valorTransf, e,n);

                                                                break;
                                                            } else {
                                                                JOptionPane.showMessageDialog(null,
                                                                        "O valor ultrapassa o saldo do cheque!");
                                                            }
                                                        }
                                                    }else{
                                                        Double analise = conta.getSaldo()
                                                                - valorTransf;

                                                        if (conta.getSaldo() > 0) {

                                                            if (conta.getSaldo()
                                                                    + conta.getCheque() >= valorTransf) {
                                                                conta.setSaldo(
                                                                        conta.getSaldo()
                                                                                - valorTransf);
                                                                conta.setCheque(conta.getCheque() + analise);
                                                                JOptionPane.showMessageDialog(null, "Valor de "
                                                                        + (valorTransf) + " transferido com sucesso!");

                                                                cont.setSaldo(cont.getSaldo() + (valorTransf));
                                                                String e = cliente.getEmail();
                                                                Long n = cliente.getTelefone();
                                                                String operacao = "a traferência";
                                                                Email email = new Email();
                                                                email.enviarnotificacao(operacao, valorTransf, e,n);
                                                                Sms sms = new Sms();
                                                                sms.enviarnotificacao(operacao, valorTransf, e, n);

                                                                break;

                                                            } else {
                                                                JOptionPane.showMessageDialog(null,
                                                                        "O valor ultrapassa o saldo da sua conta com o cheque!");
                                                            }
                                                        } else {
                                                            if (conta.getCheque() >= valorTransf) {
                                                                conta.setSaldo(
                                                                        conta.getSaldo()
                                                                                - valorTransf);
                                                                conta.setCheque(conta.getCheque() + analise);
                                                                JOptionPane.showMessageDialog(null, "Valor de "
                                                                        + valorTransf + " transferido com sucesso!");

                                                                cont.setSaldo(cont.getSaldo() + valorTransf);
                                                                String e = cliente.getEmail();
                                                                Long n = cliente.getTelefone();
                                                                String operacao = "a traferência";
                                                                Email email = new Email();
                                                                email.enviarnotificacao(operacao, valorTransf, e,n);
                                                                Sms sms = new Sms();
                                                                sms.enviarnotificacao(operacao, valorTransf, e,n);

                                                                break;
                                                            } else {
                                                                JOptionPane.showMessageDialog(null,
                                                                        "O valor ultrapassa o saldo do cheque!");
                                                            }
                                                        }
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

                for (ContaCorrente conta : cliente.getContasCor()) {
                    // Autenticando a conta que será acessada
                    if (numConta == conta.getNumeroConta()) {

                        Double analise = conta.getSaldo() - valorSaque;
                        if (analise >= 0) {
                            conta.setSaldo(conta.getSaldo() - valorSaque);
                            JOptionPane.showMessageDialog(null, "Valor de " + valorSaque + " sacado com sucesso!");
                        } else {
                            if (conta.getSaldo() > 0) {
                                if (conta.getCheque() + conta.getSaldo() >= valorSaque) {
                                    conta.setSaldo(conta.getSaldo() - valorSaque);
                                    conta.setCheque(conta.getCheque() + analise);
                                    JOptionPane.showMessageDialog(null, "Valor de " + valorSaque
                                            + " sacado com sucesso! Usamos o cheque especial!");
                                    String e = cliente.getEmail();
                                    Long n = cliente.getTelefone();
                                    String operacao = "o saque";
                                    Email email = new Email();
                                    email.enviarnotificacao(operacao, valorSaque, e,n);
                                    Sms sms = new Sms();
                                    sms.enviarnotificacao(operacao, valorSaque,e,n);
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "O valor ultrapassa o saldo da sua conta com o cheque!");
                                }
                            } else {
                                if (conta.getCheque() >= valorSaque) {
                                    conta.setSaldo(conta.getSaldo() - valorSaque);
                                    conta.setCheque(conta.getCheque() + analise);
                                    JOptionPane.showMessageDialog(null, "Valor de " + valorSaque
                                            + " sacado com sucesso! Usamos o cheque especial!");
                                    String e = cliente.getEmail();
                                    Long n = cliente.getTelefone();
                                    String operacao = "o saque";
                                    Email email = new Email();
                                    email.enviarnotificacao(operacao, valorSaque,e,n);
                                    Sms sms = new Sms();
                                    sms.enviarnotificacao(operacao, valorSaque,e,n);
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
