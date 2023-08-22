package kr.kro.schoolzone.schoolzone.domain.school.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class TempSchool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_id")
    private Long schoolId;

    @Column(name = "school_name", nullable = false)
    private String schoolName;

    @Column(name = "school_domain", nullable = false)
    private String schoolDomain;

    @Column(name = "school_location", nullable = false)
    private String schoolLocation;

    @Builder
    public TempSchool(String schoolName, String schoolDomain, String schoolLocation) {
        this.schoolName = schoolName;
        this.schoolDomain = schoolDomain;
        this.schoolLocation = schoolLocation;
    }
}
