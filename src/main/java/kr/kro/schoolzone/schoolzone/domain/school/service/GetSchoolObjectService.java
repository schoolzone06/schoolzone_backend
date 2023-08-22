package kr.kro.schoolzone.schoolzone.domain.school.service;

import kr.kro.schoolzone.schoolzone.domain.school.domain.School;
import kr.kro.schoolzone.schoolzone.domain.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetSchoolObjectService {

    private final SchoolRepository schoolRepository;

    public School execute(String schoolDomain) {
        return schoolRepository.findBySchoolDomain(schoolDomain).orElse(new School());
    }
}
