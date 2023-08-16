package kr.kro.schoolzone.schoolzone.domain.replyCommentsLike.presentation.dto.response;

import kr.kro.schoolzone.schoolzone.domain.replyComments.domain.ReplyComments;
import kr.kro.schoolzone.schoolzone.domain.replyCommentsLike.domain.ReplyCommentsLike;
import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import lombok.Getter;

@Getter
public class ReplyCommentsLikeResponse {

    private final Long replyCommentsLikeId;
    private final User user;
    private final ReplyComments replyComments;

    public ReplyCommentsLikeResponse(ReplyCommentsLike replyCommentsLike) {
        this.replyCommentsLikeId = replyCommentsLike.getReplyCommentsLikeId();
        this.user = replyCommentsLike.getUserId();
        this.replyComments = replyCommentsLike.getReplyCommentsId();
    }
}
