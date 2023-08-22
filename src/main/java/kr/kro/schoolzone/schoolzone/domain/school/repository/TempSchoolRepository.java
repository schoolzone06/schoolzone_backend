package kr.kro.schoolzone.schoolzone.domain.school.repository;

import kr.kro.schoolzone.schoolzone.domain.school.domain.TempSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempSchoolRepository extends JpaRepository<TempSchool, Long> {
}
