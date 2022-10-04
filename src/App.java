import ambiente.dominio.Conta;
import ambiente.dominio.Endereco;
import ambiente.dominio.Cliente;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

public class App {

    static List<Cliente> clientes = new ArrayList();

    public static void main(String[] args) throws Exception {

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

    public static void cadastrar() {
        Random geradorConta = new Random();

        int numConta = geradorConta.nextInt(51);

        /* Informações da pessoa */
        String Nome_p = JOptionPane.showInputDialog("Seu nome");
        String CPF_p = JOptionPane.showInputDialog("Seu CPF");
        Date data_p = null;

        /* Endereço */
        String logradouro_p = JOptionPane.showInputDialog("Qual o nome da sua rua?");
        String numero_p = JOptionPane.showInputDialog("Escreva o número da sua casa");
        String Cep_p = JOptionPane.showInputDialog("Escreva seu CEP");
        String cidade_p = JOptionPane.showInputDialog("Qual a cidade que você mora?");
        String bairro_p = JOptionPane.showInputDialog("Qual o seu bairro?");

        long convertor_num = Long.parseLong(numero_p);
        long convertor_cep = Long.parseLong(Cep_p);
        // long convertor_cpf = Long.parseLong(CPF_p);

        Endereco endereco = new Endereco(logradouro_p, convertor_num, bairro_p, cidade_p, convertor_cep);
        Conta c1 = new Conta(numConta);
        Cliente cliente_1 = new Cliente(Nome_p, CPF_p, endereco, c1);

        clientes.add(cliente_1);
    }

    public static void entra() {
        String agencia = JOptionPane.showInputDialog("Qual o número da sua agência?");
        String senha = JOptionPane.showInputDialog("Escreva a sua senha");

        


        if(agencia.equals("Ruan") && senha.equals("abc")) {

            if(clientes.size() > 0){
                int opcaoSelecionad = JOptionPane.showOptionDialog(null,
                "Cliente: " + clientes.get(0).getNome() + "\nAgência: " + clientes.get(0).getConta().getNumeroAgencia() + "\nConta: " + clientes.get(0).getConta().getNumeroConta() + "\nSaldo: " + clientes.get(0).getConta().getSaldo(),
                "Conta",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                null, null);
                
                //System.out.println("Cliente: " + clientes.get(0).getNome() + ", Agência: " + clientes.get(0).getConta().getNumeroAgencia() + ", Conta: " + clientes.get(0).getConta().getNumeroConta() + ", Saldo: " + clientes.get(0).getConta().getSaldo());
            }else{
                JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado!");

                //System.out.println("Nenhum cliente cadastrado!");
            }

            

            double saldo = 0;

            List<Integer> menu_interativo = new ArrayList<>();
            menu_interativo.add(1);
            menu_interativo.add(2);
            menu_interativo.add(3);
            menu_interativo.add(4);
            menu_interativo.add(5);

            int menuSelecionado = 1;
            while (menu_interativo.get(menuSelecionado) != 5) {
                menuSelecionado = verMenu_principal(menu_interativo);
                if (menu_interativo.get(menuSelecionado) == 1) {
                    verSaldo();
                } else if (menu_interativo.get(menuSelecionado) == 2) {
                    depositar();
                } else if (menu_interativo.get(menuSelecionado) == 2) {
                    sacar();
                } else if (menu_interativo.get(menuSelecionado) == 2) {
                    trasferir();
                }

            }

        }
    }

    public static int verMenu_principal(List<Integer> menu_interativo) {
        Object[] menusArray = menu_interativo.toArray();
        int opcaoSelecionad = JOptionPane.showOptionDialog(null,
                "1. Ver saldo \n2. Depositar \n3. Sacar \n4. Transferir \n5. Sair",
                "Menu",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                menusArray, null);
        return opcaoSelecionad;

    }

    public static void verSaldo() {
        List<Integer> saldo_menu = new ArrayList();
        saldo_menu.add(1);
        saldo_menu.add(2);
        Object[] saldoArray = saldo_menu.toArray();

        int opcaoSelecionad = JOptionPane.showOptionDialog(null,
                "1. Depositar    2. Tranferir" + "\n\nSaldo: " + clientes.get(0).getConta().getSaldo(),
                "Saldo",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                saldoArray, null);
        
        if(opcaoSelecionad == 0){
            depositar();
        }else if(opcaoSelecionad == 1){
            trasferir();
        }
    }

    public static void depositar() {
        /* JOptionPane.showMessageDialog(null, "Depositar em desenvolvimento!", null, 0); */
        String deposito = JOptionPane.showInputDialog("Quanto deseja depositar?");

        double depositoFloat = Double.parseDouble(deposito);

    }

    public static void sacar() {
        JOptionPane.showMessageDialog(null, "Sacar em desenvolvimento!", null, 0);
    }

    public static void trasferir() {
        JOptionPane.showMessageDialog(null, "Transferir em desenvolvimento!", null, 0);
    }

}
