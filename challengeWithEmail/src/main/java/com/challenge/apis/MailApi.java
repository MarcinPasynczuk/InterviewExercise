package com.challenge.apis;

import org.springframework.stereotype.Controller;

import com.challenge.model.Constants;
import com.challenge.service.MailService;

import jakarta.mail.MessagingException;

@Controller
public class MailApi {

    private final MailService mailService;

    public MailApi(MailService mailService) {
        this.mailService = mailService;
    }

    public String sendConf(String mail) {
        String confirmationSubject = "Confirmation of Registration Submission";
        String confirmationContent =
                "Hello!"
            + "<br><br>" +
                        "Thank you for submitting your registration form. We have successfully received your information, and we appreciate the time and effort you put into registering with us."
        +"<br><br>" +
        "Best regards,"
         +"<br><br>" +
        "Marcin Pasynczuk";

        try {
            mailService.sendMail(mail, confirmationSubject, confirmationContent, true);
        } catch (MessagingException e) {

            e.printStackTrace();
        }

        return Constants.SUCCESS;
    }
}