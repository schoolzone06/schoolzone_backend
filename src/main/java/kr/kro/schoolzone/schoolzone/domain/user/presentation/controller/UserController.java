package kr.kro.schoolzone.schoolzone.domain.user.presentation.controller;

import kr.kro.schoolzone.schoolzone.domain.user.presentation.dto.response.UserResponse;
import kr.kro.schoolzone.schoolzone.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }


}
