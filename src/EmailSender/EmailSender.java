package EmailSender;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import Logger.MyLogger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmailSender {
    private final Properties properties;
    private Session mailSession;
    private Transport transport;
    private MimeMessage msg = null;

    public EmailSender() throws IOException, MessagingException {
        properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\Admin\\IdeaProjects\\ComplexLab\\src\\EmailSender\\mail.properties"));
        mailSession=Session.getDefaultInstance(properties);
        MyLogger.getLogger().info("Mail Session set");
    }

    public void sendMsg(String msgText) throws MessagingException {
        msg = new MimeMessage(mailSession);
        msg.setFrom(new InternetAddress("ivankamuz14@gmail.com"));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress("kamuzivan19@gmail.com"));
        msg.setSubject("LOGGER MESSAGE");

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String strDate = now.format(formatter);
        msgText = msgText + " -" + strDate;
        msg.setText(msgText);
        try {
            transport = mailSession.getTransport();
        } catch (NoSuchProviderException e) {
            throw new RuntimeException(e);
        }
        try {
            transport.connect(null,"psge wfno cwrr pksi");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        transport.sendMessage(msg,msg.getAllRecipients());
        try {
            transport.close();
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}