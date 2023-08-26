package kr.kro.schoolzone.schoolzone.domain.auth.presentation.dto.request;

import kr.kro.schoolzone.schoolzone.domain.user.domain.Gender;
import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import lombok.Getter;

@Getter
public class SignInRequest {
    private String email;
    private String nickname;
    private String gender;

    public User toEntity() {
        return User.builder()
                .nickname(this.nickname)
                .email(this.email)
                .gender(this.email.equals("남") ? Gender.MALE : Gender.FEMALE)
                .build();
    }
}
