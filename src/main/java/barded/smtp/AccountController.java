package barded.smtp;

import barded.smtp.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AccountController {

    private final EmailService emailService;

    @PostMapping("login/mailConfirm")
    public String mailConfirm(@RequestParam String email) throws MessagingException, UnsupportedEncodingException {
        String code = emailService.sendSimpleMessage(email);
        log.info("code : {}", code);
        return code;
    }
}
