package kr.kro.schoolzone.schoolzone.domain.user.domain;

import jakarta.persistence.*;
import kr.kro.schoolzone.schoolzone.domain.school.domain.School;
import kr.kro.schoolzone.schoolzone.domain.user.presentation.dto.response.UserResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @OneToOne
    @JoinColumn(name = "school_id")
    private School schoolId;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private String grade;

    @Column(nullable = false)
    private String group;


    @Builder
    public User(School schoolId, String region, String email, String nickname, Gender gender, String grade, String group) {
        this.schoolId = schoolId;
        this.region = region;
        this.email = email;
        this.nickname = nickname;
        this.gender = gender;
        this.grade = grade;
        this.group = group;
    }

    public UserResponse toResponse() {
        return UserResponse.builder()
                .email(this.email)
                .region(this.region)
                .nickname(this.nickname)
                .schoolId(this.schoolId)
                .gender(this.gender)
                .grade(this.grade)
                .group(this.group)
                .build();
    }
}
