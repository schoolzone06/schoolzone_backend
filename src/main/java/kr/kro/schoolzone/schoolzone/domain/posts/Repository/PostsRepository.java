package kr.kro.schoolzone.schoolzone.domain.posts.Repository;

import kr.kro.schoolzone.schoolzone.domain.posts.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
