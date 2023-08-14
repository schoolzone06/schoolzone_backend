package kr.kro.schoolzone.schoolzone.domain.postsLike.presentation.dto.request;

import kr.kro.schoolzone.schoolzone.domain.posts.domain.Posts;
import kr.kro.schoolzone.schoolzone.domain.postsLike.domain.PostsLike;
import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import lombok.Getter;

@Getter
public class PostsLikeRequest {

    private Long postsId;
    private Long userId;

    public PostsLike toEntity(Posts posts, User user) {
        return PostsLike.builder()
                .postsId(posts)
                .userId(user)
                .build();
    }
}
