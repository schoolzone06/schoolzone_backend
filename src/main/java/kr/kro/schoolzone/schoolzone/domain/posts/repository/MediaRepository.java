package kr.kro.schoolzone.schoolzone.domain.posts.repository;

import kr.kro.schoolzone.schoolzone.domain.posts.domain.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {
}
