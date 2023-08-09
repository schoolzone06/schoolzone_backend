package kr.kro.schoolzone.schoolzone.domain.posts.presentation.dto.request;

import kr.kro.schoolzone.schoolzone.domain.posts.domain.Category;
import kr.kro.schoolzone.schoolzone.domain.posts.domain.Posts;
import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import lombok.Getter;

@Getter
public class NewPostsRequest {

    private Long user;
    private Category category;
    private String title;
    private String contents;

    public Posts toEntity(User user) {
        return Posts.builder()
                .userId(user)
                .category(this.category)
                .title(this.title)
                .contents(this.contents)
                .build();
    }
}
