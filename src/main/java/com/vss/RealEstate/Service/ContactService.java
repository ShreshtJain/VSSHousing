package com.vss.RealEstate.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.vss.RealEstate.Model.ContactForm;

@Service
public class ContactService {
	
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String supportMail,ContactForm form) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(supportMail);
        message.setTo(supportMail); // send to self
        message.setSubject("New Contact Form: " + form.getSubject());
        message.setText("Name: " + form.getName() + "\nEmail: " + form.getEmail() + "\n\nMessage:\n" + form.getMessage());

        mailSender.send(message);
    }

}
