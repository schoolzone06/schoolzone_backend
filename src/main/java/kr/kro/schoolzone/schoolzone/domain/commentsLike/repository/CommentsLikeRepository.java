package kr.kro.schoolzone.schoolzone.domain.commentsLike.repository;

import kr.kro.schoolzone.schoolzone.domain.comments.domain.Comments;
import kr.kro.schoolzone.schoolzone.domain.commentsLike.domain.CommentsLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsLikeRepository extends JpaRepository<CommentsLike, Long> {

    List<CommentsLike> findByCommentsId(Comments commentsId);
}
