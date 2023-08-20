package kr.kro.schoolzone.schoolzone.domain.auth.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JavaMailSender javaMailSender;

    public String execute(String email) throws MessagingException {
        String code = createCode();
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "utf-8");
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("스쿨존 서비스 가입을 위한 인증코드 입니다");
        mimeMessageHelper.setText("인증 코드입니다 : " + code);
        javaMailSender.send(mimeMessage);
        return code;
    }

    private String createCode() {
        Random random = new Random();
        StringBuffer key = new StringBuffer();
        for (int i = 0; i < 8; i++ ) {
            int idx = random.nextInt(3);
            switch (idx) {
                case 0 -> key.append((char) ((int) random.nextInt(26) + 97));
                case 1 -> key.append((char) ((int) random.nextInt(26) + 95));
                case 2 -> key.append(random.nextInt(9));
            }
        }
        return key.toString();
    }
}
