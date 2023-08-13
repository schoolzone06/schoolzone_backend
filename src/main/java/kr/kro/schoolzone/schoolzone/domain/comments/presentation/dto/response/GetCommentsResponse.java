package kr.kro.schoolzone.schoolzone.domain.comments.presentation.dto.response;

import kr.kro.schoolzone.schoolzone.domain.comments.domain.Comments;
import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetCommentsResponse {

    private final Long commentsId;
    private final User user;
    private final String contents;
    private final LocalDateTime createdTime;
    private final LocalDateTime modifiedTime;

    public GetCommentsResponse(Comments comments) {
        this.commentsId = comments.getCommentsId();
        this.user = comments.getUserId();
        this.contents = comments.getContents();
        this.createdTime = comments.getCreatedTime();
        this.modifiedTime = comments.getLastModifiedTime();
    }
}
