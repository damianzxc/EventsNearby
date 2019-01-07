package pl.coderslab.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Component
public class EmailSenderService {


    @Autowired
    private JavaMailSender mailSender;


    public void sendEmail(String to, String subject, String content) {

        MimeMessage mail = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setFrom("damian.zxc@gmail.com");
            helper.setSubject(subject);
            helper.setText(content, true);
            mail.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mail.setSubject(subject);
            mail.setText(content);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        mailSender.send(mail);
    }
}
