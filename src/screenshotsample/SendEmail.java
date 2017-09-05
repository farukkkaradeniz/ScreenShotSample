/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screenshotsample;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
/**
 *
 * @author Faruk-pc
 */
public class SendEmail {
    
    private String senderMail;
    private String receiverMail;
    private String hostName;
    private String smtpProperties;

    public SendEmail(String senderMail, String receiverMail, String hostName, String smtpProperties) {
        this.senderMail = senderMail;
        this.receiverMail = receiverMail;
        this.hostName = hostName;
        this.smtpProperties = smtpProperties;
    }
    
    public String getSenderMail() {
        return senderMail;
    }

    public void setSenderMail(String senderMail) {
        this.senderMail = senderMail;
    }

    public String getReceiverMail() {
        return receiverMail;
    }

    public void setReceiverMail(String receiverMail) {
        this.receiverMail = receiverMail;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getSmtpProperties() {
        return smtpProperties;
    }

    public void setSmtpProperties(String smtpProperties) {
        this.smtpProperties = smtpProperties;
    }
    
    public void Send(String subject,String content) {
        Properties properties = System.getProperties();
        properties.setProperty(smtpProperties, hostName);
        Session session = Session.getDefaultInstance(properties);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderMail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverMail));
            message.setSubject(subject);
            message.setText(content);
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}
