package kr.kro.schoolzone.schoolzone.domain.replyComments.presentation.dto.request;

import kr.kro.schoolzone.schoolzone.domain.comments.domain.Comments;
import kr.kro.schoolzone.schoolzone.domain.replyComments.domain.ReplyComments;
import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import lombok.Getter;

@Getter
public class NewReplyCommentsRequest {

    private Long userId;
    private Long commentsId;
    private String contents;

    public ReplyComments toEntity(User user, Comments comments) {
        return ReplyComments.builder()
                .userId(user)
                .commentsId(comments)
                .contents(this.contents)
                .build();
    }
}
