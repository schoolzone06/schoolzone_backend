package kr.kro.schoolzone.schoolzone.domain.auth.presentation.controller;

import jakarta.mail.MessagingException;
import kr.kro.schoolzone.schoolzone.domain.auth.presentation.dto.request.AuthRequest;
import kr.kro.schoolzone.schoolzone.domain.auth.presentation.dto.request.SignInRequest;
import kr.kro.schoolzone.schoolzone.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/send")
    public String send(@RequestBody AuthRequest dto) throws MessagingException {
        return authService.execute(dto.getEmail());
    }

    @PostMapping("/signIn")
    public void signIn(@RequestBody SignInRequest dto) {
        authService.signIn(dto);
    }

}
