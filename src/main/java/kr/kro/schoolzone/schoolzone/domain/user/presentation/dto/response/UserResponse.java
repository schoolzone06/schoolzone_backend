package kr.kro.schoolzone.schoolzone.domain.user.presentation.dto.response;

import kr.kro.schoolzone.schoolzone.domain.school.domain.School;
import kr.kro.schoolzone.schoolzone.domain.user.domain.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserResponse {
    private School schoolId;
    private String region;
    private String email;
    private String nickname;
    private Gender gender;
    private String grade;
    private String group;

    @Builder
    public UserResponse(School schoolId, String region, String email, String nickname, Gender gender, String grade, String group) {
        this.schoolId = schoolId;
        this.region = region;
        this.email = email;
        this.nickname = nickname;
        this.gender = gender;
        this.grade = grade;
        this.group = group;
    }
}
