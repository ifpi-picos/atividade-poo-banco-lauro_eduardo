package ambiente.dominio;

public interface Notificacao {
     
    public void enviarnotificacao(String operacao, double valor, String email, long num);

}
