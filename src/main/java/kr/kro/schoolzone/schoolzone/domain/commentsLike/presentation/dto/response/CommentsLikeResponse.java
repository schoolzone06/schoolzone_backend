package kr.kro.schoolzone.schoolzone.domain.commentsLike.presentation.dto.response;

import kr.kro.schoolzone.schoolzone.domain.comments.domain.Comments;
import kr.kro.schoolzone.schoolzone.domain.commentsLike.domain.CommentsLike;
import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import lombok.Getter;

@Getter
public class CommentsLikeResponse {

    private final Long commentsLikeId;
    private final User user;
    private final Comments comments;

    public CommentsLikeResponse(CommentsLike commentsLike) {
        this.commentsLikeId = commentsLike.getCommentsLikeId();
        this.user = commentsLike.getUserId();
        this.comments = commentsLike.getCommentsId();
    }
}
