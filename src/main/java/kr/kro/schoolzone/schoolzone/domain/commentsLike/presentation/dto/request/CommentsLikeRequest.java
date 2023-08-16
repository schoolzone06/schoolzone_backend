package kr.kro.schoolzone.schoolzone.domain.commentsLike.presentation.dto.request;

import kr.kro.schoolzone.schoolzone.domain.comments.domain.Comments;
import kr.kro.schoolzone.schoolzone.domain.commentsLike.domain.CommentsLike;
import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import lombok.Getter;

@Getter
public class CommentsLikeRequest {

    private Long userId;
    private Long commentsId;

    public CommentsLike toEntity(User user, Comments comments) {
        return CommentsLike.builder()
                .userId(user)
                .commentsId(comments)
                .build();
    }
}
