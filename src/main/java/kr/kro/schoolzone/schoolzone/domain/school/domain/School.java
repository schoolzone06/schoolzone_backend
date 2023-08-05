package kr.kro.schoolzone.schoolzone.domain.school.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String domain;

    @Column(nullable = false)
    private String location;

    @Builder
    public School(String name, String domain, String location) {
        this.name = name;
        this.domain = domain;
        this.location = location;
    }
}
