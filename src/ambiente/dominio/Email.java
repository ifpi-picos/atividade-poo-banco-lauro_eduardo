package ambiente.dominio;

import javax.swing.JOptionPane;

public class Email implements Notificacao {
    
    @Override
    public void enviarnotificacao(String operacao, double valor, String email, long num) {
        JOptionPane.showMessageDialog(null,"Mandamos uma notificação para seu e-mail, sobre a(o) "+ operacao + " de " + "R$" + valor + "\nEnviamos para: " + email);
    }

}
