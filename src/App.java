import ambiente.dominio.Conta;
import ambiente.dominio.Endereco;
import ambiente.dominio.Cliente;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class App {
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
        Cliente cliente_1 = new Cliente(Nome_p, CPF_p, endereco);

    }

    public static void entra() {
        String agencia = JOptionPane.showInputDialog("Qual o número da sua agência?");
        String senha = JOptionPane.showInputDialog("Escreva a sua senha");
        int del = JOptionPane.showConfirmDialog(null, agencia, senha, 0);
        /*UIManager.put("OptionPane.cancelButtonText", "Cancelar"); 
        UIManager.put("OptionPane.noButtonText", "Não"); 
        UIManager.put("OptionPane.yesButtonText", "Sim");*/


        if(agencia.equals("Ruan") && senha.equals("abc")) {

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
                    verSaldo();
                } else if (menu_interativo.get(menuSelecionado) == 2) {
                    depositar();
                } else if (menu_interativo.get(menuSelecionado) == 3) {
                    sacar();
                } else if (menu_interativo.get(menuSelecionado) == 4) {
                    trasferir();
                } else if(menu_interativo.get(menuSelecionado) == 5){
                    verPerfil();
                }

            }

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

    public static void verSaldo() {

    }

    public static void depositar() {

    }

    public static void sacar() {

    }

    public static void trasferir() {

    }
    public static void verPerfil(){
    
    }

}
