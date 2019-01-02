package pl.coderslab.app.emailSender;

public interface EmailSender {
    void sendEmail(String to, String subject, String context);
}
