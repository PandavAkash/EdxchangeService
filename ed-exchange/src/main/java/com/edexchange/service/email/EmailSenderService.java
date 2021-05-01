package com.edexchange.service.email;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.edexchange.service.email.model.Mail;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String fromMailId;

    @Value("${edexchange.receiver.mailid}")
    private String toMailId;

    @Autowired
    private SpringTemplateEngine templateEngine;
    private static Logger log = LoggerFactory.getLogger(EmailSenderService.class);


    public void sendEmail(Mail mail) throws MessagingException, IOException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

//        helper.addAttachment("template-cover.png", new ClassPathResource("javabydeveloper-email.PNG"));

        Context context = new Context();
        context.setVariables(mail.getProps());
    
        String html = templateEngine.process("edexchange-templates", context);

        helper.setTo(mail.getMailTo());
        helper.setText(html, true);
        helper.setSubject(mail.getSubject());
        helper.setFrom(mail.getFrom());

        emailSender.send(message);
    }

    public void sendMail(String receiverName) throws MessagingException, IOException {


        log.info("START... Sending email");

        Mail mail = new Mail();
        mail.setFrom(fromMailId);//replace with your desired email
        mail.setMailTo(toMailId);//replace with your desired email
        mail.setSubject("Appreciation from the EdExchange!!");

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("name", "User");
        model.put("location", "Pune");
        model.put("sign", "EDXCHANGE Team");
        mail.setProps(model);

        sendEmail(mail);
        log.info("END... Email sent success");


    }

}
