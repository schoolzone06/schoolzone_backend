package kr.kro.schoolzone.schoolzone.domain.user.domain;

import jakarta.persistence.*;
import kr.kro.schoolzone.schoolzone.domain.school.domain.School;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "school_id")
    private School school;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Builder
    public User(School school, String region, String email, String nickname, Gender gender) {
        this.school = school;
        this.region = region;
        this.email = email;
        this.nickname = nickname;
        this.gender = gender;
    }
}
