package kr.kro.schoolzone.schoolzone.domain.comments.repository;

import kr.kro.schoolzone.schoolzone.domain.comments.domain.Comments;
import kr.kro.schoolzone.schoolzone.domain.posts.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {

    List<Comments> findByPostsId(Posts posts);
}
