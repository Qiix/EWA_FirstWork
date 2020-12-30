
package outerService;

import java.net.PasswordAuthentication;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class envoieMail {
    public static void envoimail (String rec)
    {
        System.out.println("preparer envoi");
        Properties properties = new Properties ();
        properties.put ("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
         properties.put("mail.smtp.host", "smtp.gmail.com");
         properties.put("mail.smtp.port", "587");
         String myaccountemail = "gritliyousra@gmail.com";
         String password = "******";
         Session session = Session.getDefaultInstance(properties, new Authenticator(){

            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(myaccountemail, password);
            }
             
         });
         Message message = prepareMessage (session, myaccountemail, rec);
        try {
            Transport.send (message);
        } catch (MessagingException ex) {
            Logger.getLogger(envoieMail.class.getName()).log(Level.SEVERE, null, ex);
        }
         System.out.println("email envoyé");
         
}
             
         
       public static Message prepareMessage (Session session, String myaccountemail, String rec)
       {
        try {
            Message message = new MimeMessage(session);
            message.setFrom ( new InternetAddress(myaccountemail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(rec));
            message.setSubject("nouveaux ouvrages disponibles");
            message.setText("bienvenue dans notre librairie!! nous avons de nouveaux ouvrages en stock ");
            return message;
        } catch (MessagingException ex) {
            Logger.getLogger(envoieMail.class.getName()).log(Level.SEVERE, null, ex);
        }
          return null; 
       }
    
    
    
    
    
}
