/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

/**
 *
 * @author Thyago Pacher
 */
import java.util.Properties;   
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;   


//clase que retorna uma autenticacao para ser enviada e verificada pelo servidor smtp  

public class Email {
    private final String mailSMTPServer;  
    private final String mailSMTPServerPort;  
    String usuario;
    String senha;
    /* 
     * quando instanciar um Objeto ja sera atribuido o servidor SMTP do GMAIL  
     * e a porta usada por ele 
     */  
    public Email() { //Para o GMAIL   
        mailSMTPServer      = "smtp.gmail.com";  
        mailSMTPServerPort  = "465";  
    }  
    
    /* 
     * caso queira mudar o servidor e a porta, so enviar para o contrutor 
     * os valor como string 
     */  
    public Email(String mailSMTPServer, String mailSMTPServerPort, String usuario, String senha) { //Para outro Servidor  
        this.mailSMTPServer = mailSMTPServer;  
        this.mailSMTPServerPort = mailSMTPServerPort;  
        this.usuario = usuario;
        this.senha = senha;
    }  

      
    public String sendMail(String from, String to, String subject, String message) {  
        String     res   = "";  
        Properties props = new Properties();    
        props.put("mail.transport.protocol", "smtp"); //define protocolo de envio como SMTP  
        props.put("mail.smtp.starttls.enable","true");   
        props.put("mail.smtp.host", mailSMTPServer); //server SMTP do GMAIL  
        props.put("mail.smtp.auth", "true"); //ativa autenticacao  
        props.put("mail.smtp.user", from); //usuario ou seja, a conta que esta enviando o email (tem que ser do GMAIL)  
        props.put("mail.debug", "true");  
        props.put("mail.smtp.port", mailSMTPServerPort); //porta  
        props.put("mail.smtp.socketFactory.port", mailSMTPServerPort); //mesma porta para o socket  
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");  
        props.put("mail.smtp.socketFactory.fallback", "false");  
          
        //Cria um autenticador que sera usado a seguir  
        SimpleAuth auth = new SimpleAuth (usuario, senha);  
          
        //Session - objeto que ira realizar a conexão com o servidor  
        /*Como há necessidade de autenticação é criada uma autenticacao que 
         * é responsavel por solicitar e retornar o usuário e senha para  
         * autenticação */  
        Session session = Session.getDefaultInstance(props, auth);  
        session.setDebug(true); //Habilita o LOG das ações executadas durante o envio do email  
        //Objeto que contém a mensagem  
        Message msg = new MimeMessage(session);  
        try {  
            //Setando o destinatário  
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));  
            //Setando a origem do email  
            msg.setFrom(new InternetAddress(from));  
            //Setando o assunto  
            msg.setSubject(subject);  
            
            //Setando o conteúdo/corpo do email  
            msg.setContent(message,"text/plain");  
  
        } catch (MessagingException ex) {  
            res += "Erro ao definir o escopo da mensagem:\n" + ex;
        }  
          
        //Objeto encarregado de enviar os dados para o email  
        try {  
            Transport tr = session.getTransport("smtp"); //define smtp para transporte  
            /* 
             *  1 - define o servidor smtp 
             *  2 - seu nome de usuario do gmail 
             *  3 - sua senha do gmail 
             */  
            tr.connect(mailSMTPServer, usuario, senha);  
            msg.saveChanges(); // don't forget this  
            //envio da mensagem  
           
            tr.sendMessage(msg, msg.getAllRecipients());  
            tr.close();  
        } catch (MessagingException ex) {  
            res += "Erro ao executar a mensagem:\n" + ex;  
        } 
        return res;
    }  
  
//    public static void main(String[] args) {
//        Email sd = new Email("smtp.gmail.com","465", "thyago.pacher@gmail.com", "brasil1602");
//        sd.sendMail("thyagopacher@bol.com.br","oldwolf1602@hotmail.com","assunto","mensagem"); 
//    }    
    
}  

class SimpleAuth extends Authenticator {  
    
    public String username = null;  
    public String password = null;  

    SimpleAuth(String user, String pwd) {  
        username = user;  
        password = pwd;  
    }  
  
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {  
        return new PasswordAuthentication (username,password);  
    }      

}
