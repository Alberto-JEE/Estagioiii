/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagioiii.auxiliares;

import br.com.estagioiii.model.EnviaEmailModel;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EnviaEmail {

    public static boolean entregaDeEmail(EnviaEmailModel enviaEmailModel) {

        Properties props = new Properties();

        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        SimpleAuth auth = null;
        auth = new SimpleAuth("estagioiiiunemat@gmail.com", "123654789estagio");

        Session session = Session.getDefaultInstance(props, auth);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("estagioiiiunemat@gmail.com"));
            if (enviaEmailModel != null) {
            String destinos = String.valueOf(enviaEmailModel.getDestinos());            
                Address[] toUser = InternetAddress.parse(destinos);
                message.setRecipients(Message.RecipientType.TO, toUser);
                message.setSubject(enviaEmailModel.getAssunto());
                message.setText(enviaEmailModel.getMensagem());

                Transport.send(message);

                return true;
            }
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}

class SimpleAuth extends Authenticator {
    public String username = null;
    public String password = null;

    public SimpleAuth(String user, String senha) {
        username = user;
        password = senha;
    }
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }
}
