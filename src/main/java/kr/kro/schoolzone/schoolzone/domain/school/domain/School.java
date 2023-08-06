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
    @Column(name = "school_id")
    private Long schoolId;

    @Column(nullable = false, name = "school_name")
    private String schoolName;

    @Column(nullable = false, unique = true, name = "school_domain")
    private String schoolDomain;

    @Column(nullable = false, name = "school_location")
    private String schoolLocation;

    @Builder
    public School(String schoolName, String schoolDomain, String schoolLocation) {
        this.schoolName = schoolName;
        this.schoolDomain = schoolDomain;
        this.schoolLocation = schoolLocation;
    }
}
