package ambiente.dominio;

import javax.swing.JOptionPane;

/*import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;*/

public class Email implements Notificacao {
    
    @Override
    public void enviarnotificacao(String operacao, double valor, String email, long num) {
        JOptionPane.showMessageDialog(null,"Mandamos uma notificação para seu e-mail, sobre a(o) "+ operacao + " de " + valor + "R$" + "\nEnviamos para: " + email);
    }

public void enviar_EMAIL(){

   /* String meuEmail = "capic.2022118tads0170@aluno.ifpi.edu.br";
    String senha = "34224366ruan";

    SimpleEmail email = new SimpleEmail();
    email.setHostName("smtp.gmail.com");
    email.setSmtpPort(465);
    email.setAuthenticator(new DefaultAuthenticator(meuEmail, senha));
    email.setSSLOnConnect(true);

    try{

        email.setFrom(meuEmail);
        email.setSubject("Mudança no Banco Maut");
        email.setMsg("Você mudou algo");
        email.addTo(meuEmail);
        email.setAuthentication("login", "senha");
        email.send();
        System.out.println("Enviado com sucesso!");

    }catch(Exception e){
        e.printStackTrace();
    }*/   
}

}
