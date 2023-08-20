package kr.kro.schoolzone.schoolzone.domain.auth.controller;

import jakarta.mail.MessagingException;
import kr.kro.schoolzone.schoolzone.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/email")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/send")
    public String checkEmail(@RequestBody AuthRequestDto dto) throws MessagingException {
        return authService.execute(dto.getEmail());
    }

}
