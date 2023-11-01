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

/**
 * Цей клас відправляє email повідомлення для логування.
 */
public class EmailSender {
    private final Properties properties;
    private Session mailSession;
    private Transport transport;
    private MimeMessage msg = null;

    /**
     * Конструктор для ініціалізації об'єкта EmailSender.
     *
     * @throws IOException виникає, якщо виникли помилки під час зчитування конфігураційних параметрів.
     * @throws MessagingException виникає, якщо виникли помилки під час створення поштової сесії або відправки повідомлення.
     */
    public EmailSender() throws IOException, MessagingException {
        // Завантаження конфігураційних параметрів для email з файлу mail.properties
        properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\Admin\\IdeaProjects\\ComplexLab\\src\\EmailSender\\mail.properties"));
        mailSession = Session.getDefaultInstance(properties);
        MyLogger.getLogger().info("Успішно ініціалізовано поштову сесію");
    }

    /**
     * Відправляє email повідомлення з вказаним текстом.
     *
     * @param msgText текст повідомлення, яке буде відправлене.
     * @throws MessagingException виникає, якщо виникли помилки під час відправки повідомлення.
     */
    public void sendMsg(String msgText) throws MessagingException {
        msg = new MimeMessage(mailSession);

        // Встановлення адреси відправника і отримувача
        msg.setFrom(new InternetAddress("ivankamuz14@gmail.com"));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress("kamuzivan19@gmail.com"));

        // Встановлення теми повідомлення
        msg.setSubject("LOGGER MESSAGE");

        // Додавання дати та часу до тексту повідомлення
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String strDate = now.format(formatter);
        msgText = msgText + " - " + strDate;

        // Встановлення тексту повідомлення
        msg.setText(msgText);

        try {
            transport = mailSession.getTransport();
        } catch (NoSuchProviderException e) {
            throw new RuntimeException(e);
        }

        // Встановлення підключення до поштового серверу і відправка повідомлення
        try {
            transport.connect(null, "psge wfno cwrr pksi");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        transport.sendMessage(msg, msg.getAllRecipients());

        // Закриття підключення після відправки повідомлення
        try {
            transport.close();
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
