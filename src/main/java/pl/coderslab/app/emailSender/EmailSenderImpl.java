package pl.coderslab.app.emailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.coderslab.app.emailSender.EmailSender;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service("emailSender")
public class EmailSenderImpl implements EmailSender {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(String to, String subject, String content) {

        MimeMessage mail = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setFrom("noreply@gmail.com");
            helper.setSubject(subject);
            helper.setText(content, true);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        mailSender.send(mail);

//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(context);
//        mailSender.send(message);

    }
}
