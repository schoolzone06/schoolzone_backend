package kr.kro.schoolzone.schoolzone.domain.replyCommentsLike.presentation.dto.request;

import kr.kro.schoolzone.schoolzone.domain.replyComments.domain.ReplyComments;
import kr.kro.schoolzone.schoolzone.domain.replyCommentsLike.domain.ReplyCommentsLike;
import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import lombok.Getter;

@Getter
public class ReplyCommentsLikeRequest {

    private Long userId;
    private Long replyCommentsId;

    public ReplyCommentsLike toEntity(User user, ReplyComments replyComments) {
        return ReplyCommentsLike.builder()
                .userId(user)
                .replyCommentsId(replyComments)
                .build();
    }
}
