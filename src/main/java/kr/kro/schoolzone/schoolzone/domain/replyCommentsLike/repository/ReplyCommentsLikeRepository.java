package kr.kro.schoolzone.schoolzone.domain.replyCommentsLike.repository;

import kr.kro.schoolzone.schoolzone.domain.replyComments.domain.ReplyComments;
import kr.kro.schoolzone.schoolzone.domain.replyCommentsLike.domain.ReplyCommentsLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyCommentsLikeRepository extends JpaRepository<ReplyCommentsLike, Long> {

    List<ReplyCommentsLike> findByReplyCommentsId(ReplyComments replyCommentsId);
}
