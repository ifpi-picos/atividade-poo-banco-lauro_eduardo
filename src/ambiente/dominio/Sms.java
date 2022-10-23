package ambiente.dominio;

import javax.swing.JOptionPane;

public class Sms implements Notificacao {

    @Override
    public void enviarnotificacao(String operacao, double valor, String email, long num) {

        JOptionPane.showMessageDialog(null,"Mandamos uma notificação para seu número, sobre a(o) "+ operacao + " de " + valor + "R$" + "\n Enviamos para: " + num);
        
    }
    

}
