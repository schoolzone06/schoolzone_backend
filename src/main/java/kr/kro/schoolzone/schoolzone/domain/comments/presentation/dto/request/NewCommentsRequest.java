package kr.kro.schoolzone.schoolzone.domain.comments.presentation.dto.request;

import kr.kro.schoolzone.schoolzone.domain.comments.domain.Comments;
import kr.kro.schoolzone.schoolzone.domain.posts.domain.Posts;
import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import lombok.Getter;

@Getter
public class NewCommentsRequest {

    private Long userId;
    private Long postsId;
    private String contents;

    public Comments toEntity(User userId, Posts postsId) {
        return Comments.builder()
                .userId(userId)
                .postsId(postsId)
                .contents(this.contents)
                .build();
    }
}
