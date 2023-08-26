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
    @Column(name = "school_id")
    private String schoolId;

    @Column(name = "school_name", nullable = false)
    private String schoolName;

    @Column(name = "school_domain", nullable = false)
    private String schoolDomain;

    @Column(name = "school_location", nullable = false)
    private String schoolLocation;

    @Column(name = "school_office_code", nullable = false)
    private String schoolOfficeCode;

    @Builder
    public School(String schoolId, String schoolName, String schoolDomain, String schoolLocation, String schoolOfficeCode) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.schoolDomain = schoolDomain;
        this.schoolLocation = schoolLocation;
        this.schoolOfficeCode = schoolOfficeCode;
    }
}
