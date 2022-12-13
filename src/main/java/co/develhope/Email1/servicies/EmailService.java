package co.develhope.Email1.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender emailSender;


    public void sendTo(String title, String text, String email) {
        SimpleMailMessage sms = new SimpleMailMessage();
        sms.setTo(email);
        sms.setSubject(title);
        sms.setText(text);
        emailSender.send(sms);
    }
}
