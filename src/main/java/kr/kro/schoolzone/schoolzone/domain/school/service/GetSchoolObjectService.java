package kr.kro.schoolzone.schoolzone.domain.school.service;

import kr.kro.schoolzone.schoolzone.domain.school.domain.School;
import kr.kro.schoolzone.schoolzone.domain.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetSchoolObjectService {

    private final SchoolRepository schoolRepository;

    public School findById(Long schoolId) {
        return schoolRepository.findById(schoolId).orElse(new School());
    }

    public School findByDomain(String schoolDomain) {
        return schoolRepository.findBySchoolDomain(schoolDomain).orElse(new School());
    }
}
