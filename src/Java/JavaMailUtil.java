package Java;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import static Java.CovidAPI.getStateMailMessage;
import static Java.CovidUtility.*;
import static Java.CustomText.writeMail;

public class JavaMailUtil extends Tokens{
    public static void sendMail(String recipient, String type) throws MessagingException {
        System.out.println("Preparing to send Email.");
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = getMailID();
        String password = getMailPassword();

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        Message message = prepareMessage(session, myAccountEmail, recipient, type);

        Transport.send(message);
        System.out.println("Message sent Successfully!!!");
    }
    private static Message prepareMessage(Session session, String myAccountEmail, String recipient, String messageType) {
        Message message = new MimeMessage(session);
        try {
            String text = null;
            if (messageType.equals("Links")) {
                text = displayCovidPrecaution();
            }
            if (messageType.equals("covidStateDetail")) {
                text = getStateMailMessage();
            }

//            String text = "\n\nSome Error, Ignore and Try Again!!! \n\n";
//            String text = writeMail();
//            String text = displayCovidVaccine();
//            String text = displayCovidApp();
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient ));
            message.setSubject("CORONA TRACKER");
            message.setText(text);
            return message;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
