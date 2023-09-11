package kr.kro.schoolzone.schoolzone.domain.posts.repository;

import kr.kro.schoolzone.schoolzone.domain.posts.domain.Media;
import kr.kro.schoolzone.schoolzone.domain.posts.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {

    List<Media> findByPosts(Posts postsId);
}
