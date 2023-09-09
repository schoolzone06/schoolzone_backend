package kr.kro.schoolzone.schoolzone.domain.posts.repository;

import kr.kro.schoolzone.schoolzone.domain.posts.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
}
