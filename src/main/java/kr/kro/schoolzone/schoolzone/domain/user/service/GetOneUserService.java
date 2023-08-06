package kr.kro.schoolzone.schoolzone.domain.user.service;

import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import kr.kro.schoolzone.schoolzone.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetOneUserService {

    private final UserRepository userRepository;

    public User execute(Long id) {
        return userRepository.findById(id).orElse(new User());
    }
}
