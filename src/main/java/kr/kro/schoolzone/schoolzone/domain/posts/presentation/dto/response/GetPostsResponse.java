package kr.kro.schoolzone.schoolzone.domain.posts.presentation.dto.response;

import kr.kro.schoolzone.schoolzone.domain.posts.domain.Category;
import kr.kro.schoolzone.schoolzone.domain.posts.domain.Posts;
import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetPostsResponse {

    private final Long postsId;
    private final User user;
    private final Category category;
    private final String title;
    private final String contents;
    private final LocalDateTime createdTime;
    private final LocalDateTime lastModifiedTime;

    public GetPostsResponse(Posts posts) {
        this.postsId = posts.getPostsId();
        this.user = posts.getUserId();
        this.category = posts.getCategory();
        this.title = posts.getTitle();
        this.contents = posts.getContents();
        this.createdTime = posts.getCreatedTime();
        this.lastModifiedTime = posts.getLastModifiedTime();
    }
}
