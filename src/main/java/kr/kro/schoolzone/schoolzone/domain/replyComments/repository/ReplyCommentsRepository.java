package kr.kro.schoolzone.schoolzone.domain.replyComments.repository;

import kr.kro.schoolzone.schoolzone.domain.comments.domain.Comments;
import kr.kro.schoolzone.schoolzone.domain.replyComments.domain.ReplyComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyCommentsRepository extends JpaRepository<ReplyComments, Long> {

    List<ReplyComments> findByCommentsId(Comments commentsId);
}
