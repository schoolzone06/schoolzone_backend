package kr.kro.schoolzone.schoolzone.domain.posts.presentation.dto.response;

import kr.kro.schoolzone.schoolzone.domain.posts.domain.Category;
import kr.kro.schoolzone.schoolzone.domain.posts.domain.Posts;
import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import lombok.Getter;

@Getter
public class PostsAllResponse {

    private final Long postsId;
    private final User user;
    private final Category category;
    private final String title;
    private final String contents;

    public PostsAllResponse(Posts posts) {
        this.postsId = posts.getPostsId();
        this.user = posts.getUserId();
        this.category = posts.getCategory();
        this.title = posts.getTitle();
        this.contents = posts.getContents();
    }
}
