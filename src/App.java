import ambiente.dominio.Conta;
import ambiente.dominio.Endereco;
import ambiente.dominio.Cliente;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
// import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;
// import javax.swing.UIManager;

public class App {

    static List<Cliente> clientes = new ArrayList<>();

    public static void main(String[] agrgs) throws Exception {

        List<Integer> menu = new ArrayList<>();
        menu.add(1);
        menu.add(2);
        menu.add(3);

        int menuSelecionado = 1;
        while (menu.get(menuSelecionado) != 3) {
            menuSelecionado = verMenu(menu);
            if (menu.get(menuSelecionado) == 1) {
                cadastrar();
            } else if (menu.get(menuSelecionado) == 2) {
                entra();
            }

        }

    }

    public static int verMenu(List<Integer> menu) {
        Object[] menusArray = menu.toArray();
        int opcaoSelecionad = JOptionPane.showOptionDialog(null,
                "1. Cadastrar \n2. Entrar \n3. Sair",
                "Menu",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                menusArray, null);
        return opcaoSelecionad;
    }

    public static void cadastrar() throws ParseException {
        Random geradorConta = new Random();

        int numConta = geradorConta.nextInt(51);
        /* Informações da pessoa */
        String Nome_p = JOptionPane.showInputDialog("Seu nome: ");
        String CPF_p = JOptionPane.showInputDialog("Seu CPF: ");
        for (Cliente cliente : clientes) {
            // Autenticando o cliente que será acessado
            if (CPF_p.equals(cliente.getCPF())) {
                JOptionPane.showMessageDialog(null, "Esse CPF já está cadastrado!");
                entra();
                }
        }
        
        List<Integer> menu = new ArrayList<>();
                    menu.add(1);
                    menu.add(2);

        Object[] menuEntrar = menu.toArray();
        int opcSelecionada = JOptionPane.showOptionDialog(null,
                            "1. Corrente \n2. Poupança", "Tipo de Conta", JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE, null, menuEntrar, null);

        String senha_p = JOptionPane.showInputDialog("Crie uma senha: ");
        String email_p = JOptionPane.showInputDialog("Digite seu email: ");
        String telefone_p = JOptionPane.showInputDialog("Digite seu telefone: ");
        String data_p = JOptionPane.showInputDialog(null, "Digite sua data de nascimento: (dd/mm/yyyy)");

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        Date dataFormat = formato.parse(data_p);

        /* Endereço */
        String logradouro_p = JOptionPane.showInputDialog("Qual o nome da sua rua?");
        String numero_p = JOptionPane.showInputDialog("Digite o número da sua casa: ");
        String bairro_p = JOptionPane.showInputDialog("Qual o seu bairro?");
        String cidade_p = JOptionPane.showInputDialog("Qual a cidade que você mora?");
        String Cep_p = JOptionPane.showInputDialog("Digite seu CEP: ");
        String id_gerado = id_endereco();

        long convertor_num = Long.parseLong(numero_p);
        long convertor_cep = Long.parseLong(Cep_p);
        long telefone_conv = Long.parseLong(telefone_p);

        Endereco endereco = new Endereco(logradouro_p, convertor_num, bairro_p, cidade_p, convertor_cep, id_gerado);

        String tipo = "";

        if(opcSelecionada == 0){
            tipo = "Corrente";
            

        }else if(opcSelecionada == 1){
            tipo = "Poupança";
        }

        Conta c1 = new Conta(numConta, tipo);
        Cliente cliente = new Cliente(Nome_p, CPF_p, email_p, telefone_conv, endereco, dataFormat, c1, senha_p);
        clientes.add(cliente);

        JOptionPane.showMessageDialog(null, "Número da conta: " + numConta);
       
    }

    public static void entra()  {

        if (clientes.size() > 0) {

            String userCPF = JOptionPane.showInputDialog("Digite seu CPF: ");
            String userSenha = JOptionPane.showInputDialog("Digite sua senha: ");

            // Percorrendo clientes
            for (Cliente cliente : clientes) {
                // Autenticando cliente
                if (userCPF.equals(cliente.getCPF()) && userSenha.equals(cliente.getSenha())) {

                    JOptionPane.showMessageDialog(null,
                            "Nome: " + cliente.getNome() + "\nQuantidade de contas: " + cliente.getContas().size());

                    // Criando menu pós-login
                    List<Integer> menu = new ArrayList<>();
                    menu.add(1);
                    menu.add(2);

                    Object[] menuEntrar = menu.toArray();
                    int opcSelecionada = JOptionPane.showOptionDialog(null,
                            "1. Entrar em conta existente \n2. Criar nova conta", "Conta", JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE, null, menuEntrar, null);

                    if (opcSelecionada == 0) {

                        List<Integer> opcoes = new ArrayList<>();

                        for (Conta conta : cliente.getContas()) {
                            opcoes.add(conta.getNumeroConta());
                        }

                        Object[] opcoesConta = opcoes.toArray();
                        int contaSelecionada = JOptionPane.showOptionDialog(null, "Selecione a conta: ", "Contas",
                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoesConta, null);

                        int num_Conta = opcoes.get(contaSelecionada);

                        // System.out.println(num_Conta);

                        // Percorrendo contas do cliente
                        for (Conta conta : cliente.getContas()) {
                            // Autenticando conta
                            if (num_Conta == conta.getNumeroConta()) {
                                // System.out.println("Hello");

                                List<Integer> menu_interativo = new ArrayList<>();
                                menu_interativo.add(1);
                                menu_interativo.add(2);
                                menu_interativo.add(3);
                                menu_interativo.add(4);
                                menu_interativo.add(5);
                                menu_interativo.add(6);

                                int menuSelecionado = 1;
                                while (menu_interativo.get(menuSelecionado) != 6) {
                                    menuSelecionado = verMenu_principal(menu_interativo);
                                    if (menu_interativo.get(menuSelecionado) == 1) {
                                        // Passando o CPF e o número da conta do cliente
                                        verSaldo(userCPF, num_Conta);
                                    } else if (menu_interativo.get(menuSelecionado) == 2) {
                                        depositar(userCPF, num_Conta);
                                    } else if (menu_interativo.get(menuSelecionado) == 3) {
                                        sacar(userCPF, num_Conta);
                                    } else if (menu_interativo.get(menuSelecionado) == 4) {
                                        trasferir(userCPF, num_Conta);
                                    } else if (menu_interativo.get(menuSelecionado) == 5) {
                                        verPerfil(userCPF, num_Conta);
                                    }

                                }
                            }
                        }
                    } else if (opcSelecionada == 1) {
                        List<Integer> menu_interativo = new ArrayList<>();
                            menu_interativo.add(1);
                            menu_interativo.add(2);
    
                            Object[] menusArray = menu_interativo.toArray();
                            int opcaoSelecionad = JOptionPane.showOptionDialog(null,
                                    "1. Poupança \n2. Corrente ", "Menu",
                                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                                    menusArray, null);
                        
                        Random geradorConta = new Random();

                        int numConta = geradorConta.nextInt(51);

                        if(opcaoSelecionad == 0){
                            String tipo = "Poupança";
                            Conta c = new Conta(numConta, tipo);
                            cliente.addConta(c);
                        }else if(opcaoSelecionad == 1){
                            String tipo = "Corrente";
                            Conta c = new Conta(numConta,tipo);
                            cliente.addConta(c);
                        }
                        
                        JOptionPane.showMessageDialog(null, "Número da conta: " + numConta);
                    }
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado!");
        }

    }

    public static int verMenu_principal(List<Integer> menu_interativo) {
        Object[] menusArray = menu_interativo.toArray();
        int opcaoSelecionad = JOptionPane.showOptionDialog(null,
                "1. Ver saldo \n2. Depositar \n3. Sacar \n4. Transferir \n5. Ver perfil \n6. Sair",
                "Menu",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                menusArray, null);
        return opcaoSelecionad;

    }

    public static void verSaldo(String CPF, int numConta) {

        for (Cliente cliente : clientes) {
            // Autenticando o cliente que será acessado
            if (CPF.equals(cliente.getCPF())) {

                for (Conta conta : cliente.getContas()) {
                    // Autenticando a conta que será acessada
                    if (numConta == conta.getNumeroConta()) {
                        JOptionPane.showMessageDialog(null,
                                "Cliente: " + cliente.getNome() + "\nSaldo: " + conta.getSaldo());
                    }
                }
            }
        }

    }

    public static void depositar(String CPF, int numConta) {
 
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

    public static void sacar(String CPF, int numConta) {
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
                           if(conta.getSaldo() > 0){
                            if(conta.getcheque_especial() + conta.getSaldo() >= valorSaque ){
                                conta.setSaldo(conta.getSaldo() - valorSaque);
                                conta.setcheque_especial(conta.getcheque_especial() + analise);
                                JOptionPane.showMessageDialog(null, "Valor de " + valorSaque + " sacado com sucesso! Usamos o cheque especial!");
                            }else{
                                JOptionPane.showMessageDialog(null, "O valor ultrapassa o saldo da sua conta com o cheque!");
                            }
                           }else{
                            if(conta.getcheque_especial() >= valorSaque ){
                                conta.setSaldo(conta.getSaldo() - valorSaque);
                                conta.setcheque_especial(conta.getcheque_especial() + analise);
                                JOptionPane.showMessageDialog(null, "Valor de " + valorSaque + " sacado com sucesso! Usamos o cheque especial!");
                            }else{
                                JOptionPane.showMessageDialog(null, "O valor ultrapassa o saldo do cheque!");
                            }
                           }
                        }
                    }
                }
            }
        }
    }

    public static void trasferir(String CPF, int numConta) {


        String transferencia = JOptionPane.showInputDialog(null, "Qual valor deseja transferir?");
        String pesDestino = JOptionPane.showInputDialog(null, "Qual o CPF do destinatário?");
        String numDestino = JOptionPane.showInputDialog(null, "Qual o número da conta do destinatário?");

        Double valorTransf = Double.parseDouble(transferencia);
        Double taxaTransfPop = valorTransf*0.05;
        Double taxaTransfCor = valorTransf*0.10;
        Integer numConDestino = Integer.parseInt(numDestino);

        for (Cliente cliente : clientes) {
            // Autenticando o cliente que será acessado
            if (CPF.equals(cliente.getCPF())) {

                for (Conta conta : cliente.getContas()) {
                    // Autenticando a conta que será acessada
                    if (numConta == conta.getNumeroConta()) {

                        System.out.println(conta.getcheque_especial());

                        if(conta.getType() == "Poupança"){

                            valorTransf = valorTransf + taxaTransfPop;

                        }else if(conta.getType() == "Corrente" && conta.getNumTransf() >= 2){

                            valorTransf = valorTransf + taxaTransfCor;

                        }

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

                                                    if(conta.getType() == "Poupança"){

                                                        conta.setSaldo(conta.getSaldo() - valorTransf);
                                                        conta.setNumTransf(conta.getNumTransf() + 1);
                                                        JOptionPane.showMessageDialog(null, "Valor de " + (valorTransf - taxaTransfPop) + " transferido com sucesso!");

                                                        cont.setSaldo(cont.getSaldo() + (valorTransf - taxaTransfPop));

                                                        break;

                                                    }else if(conta.getType() == "Corrente" && conta.getNumTransf() >= 2){

                                                        conta.setSaldo(conta.getSaldo() - valorTransf);
                                                        conta.setNumTransf(conta.getNumTransf() + 1);
                                                        JOptionPane.showMessageDialog(null, "Valor de " + (valorTransf - taxaTransfCor) + " transferido com sucesso!");

                                                        cont.setSaldo(cont.getSaldo() + (valorTransf - taxaTransfCor));

                                                        break;

                                                    }else{

                                                        conta.setSaldo(conta.getSaldo() - valorTransf);
                                                        conta.setNumTransf(conta.getNumTransf() + 1);
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

                                                        Double analise = conta.getSaldo() - valorTransf;

                                                        if(conta.getSaldo() > 0){
                                        
                                                            if(conta.getSaldo() + conta.getcheque_especial() >= valorTransf){
                                                                conta.setSaldo(conta.getSaldo() - valorTransf);
                                                                conta.setcheque_especial(conta.getcheque_especial() + analise);
                                                                JOptionPane.showMessageDialog(null, "Valor de " + (valorTransf - taxaTransfPop) + " transferido com sucesso!");

                                                                cont.setSaldo(cont.getSaldo() + (valorTransf - taxaTransfPop));

                                                                break;

                                                            }else{
                                                                JOptionPane.showMessageDialog(null, "O valor ultrapassa o saldo da sua conta com o cheque!");
                                                            }
                                                        }else{
                                                            if(conta.getcheque_especial() >= valorTransf){
                                                                conta.setSaldo(conta.getSaldo() - valorTransf);
                                                                conta.setcheque_especial(conta.getcheque_especial() + analise);
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

    public static void verPerfil(String CPF, int numConta) {
        for (Cliente cliente : clientes) {
            // Autenticando o cliente que será acessado
            if (CPF.equals(cliente.getCPF())) {

                for (Conta conta : cliente.getContas()) {
                    // Autenticando a conta que será acessada
                    if (numConta == conta.getNumeroConta()) {
                        JOptionPane.showMessageDialog(null, "Nome: " + cliente.getNome() + "\nEmail: " + cliente.getEmail() + "\nTelefone: " + cliente.getTelefone() + "\nRua: "
                                + cliente.getEndereco().getLogra() + ", Número: " + cliente.getEndereco().getNume()
                                + "\nBairro: " + cliente.getEndereco().getBairro() + "\nCidade: "
                                + cliente.getEndereco().getCidade() + "\nCEP: " + cliente.getEndereco().getCEP() + "\nData de Nascimento: " + cliente.getDataNascimento() +"\n ID do endereço: "+cliente.getEndereco().getid() + "\nTipo de conta: "+ conta.getType() + "\nNúmero de Transferências: " + conta.getNumTransf());
                    }
                }
            }
        }
    }

public static String id_endereco(){

    Random geradorConta = new Random();

    int num1 = geradorConta.nextInt(9);
    int num2 = geradorConta.nextInt(9);
    int num3 = geradorConta.nextInt(9);
    int num4 = geradorConta.nextInt(9);
    int num5 = geradorConta.nextInt(9);
    int num6 = geradorConta.nextInt(9);
    int num7 = geradorConta.nextInt(9);
    int num8 = geradorConta.nextInt(9);
    int num9 = geradorConta.nextInt(9);

    String str = "" + num1 + num2 + num3 + num4 + num5+ num6 + num7 + num8 + num9;

    return str;    
}

}
