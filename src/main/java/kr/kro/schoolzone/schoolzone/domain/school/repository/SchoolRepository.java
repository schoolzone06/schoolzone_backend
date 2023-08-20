package kr.kro.schoolzone.schoolzone.domain.school.repository;

import kr.kro.schoolzone.schoolzone.domain.school.domain.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
}
