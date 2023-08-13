package kr.kro.schoolzone.schoolzone.domain.replyComments.presentation.dto.response;

import kr.kro.schoolzone.schoolzone.domain.comments.domain.Comments;
import kr.kro.schoolzone.schoolzone.domain.replyComments.domain.ReplyComments;
import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import lombok.Getter;

@Getter
public class GetReplyCommentsResponse {

    private final Long replyCommentsId;
    private final User user;
    private final Comments comments;
    private final String contents;

    public GetReplyCommentsResponse(ReplyComments replyComments) {
        this.replyCommentsId = replyComments.getReplyCommentsId();
        this.user = replyComments.getUserId();
        this.comments = replyComments.getCommentsId();
        this.contents = replyComments.getContents();
    }
}
