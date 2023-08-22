package kr.kro.schoolzone.schoolzone.domain.user.service;

import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import kr.kro.schoolzone.schoolzone.domain.user.presentation.dto.response.UserResponse;
import kr.kro.schoolzone.schoolzone.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    
    public UserResponse getUser(Long id) {
        return userRepository.findById(id).orElse(User.builder().build()).toResponse();
    }
}
