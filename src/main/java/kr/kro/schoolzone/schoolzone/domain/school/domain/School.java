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

    @Column(name = "school_name", nullable = false)
    private String schoolName;

    @Column(name = "school_domain", nullable = false)
    private String schoolDomain;

    @Column(name = "school_location", nullable = false)
    private String schoolLocation;

    @Column(name = "school_office_code", nullable = false)
    private String schoolOfficeCode;

    @Column(name = "school_code", nullable = false)
    private String schoolCode;

    @Builder
    public School(String schoolName, String schoolDomain, String schoolLocation, String schoolOfficeCode, String schoolCode) {
        this.schoolName = schoolName;
        this.schoolDomain = schoolDomain;
        this.schoolLocation = schoolLocation;
        this.schoolOfficeCode = schoolOfficeCode;
        this.schoolCode = schoolCode;
    }
}
