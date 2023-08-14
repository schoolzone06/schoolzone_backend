package kr.kro.schoolzone.schoolzone.domain.postsLike.presentation.dto.response;

import kr.kro.schoolzone.schoolzone.domain.posts.domain.Posts;
import kr.kro.schoolzone.schoolzone.domain.postsLike.domain.PostsLike;
import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import lombok.Getter;

@Getter
public class PostsLikeListResponse {

    private final Long postsLikeId;
    private final Posts posts;
    private final User user;

    public PostsLikeListResponse(PostsLike postsLike) {
        this.postsLikeId = postsLike.getPostsLikeId();
        this.posts = postsLike.getPostsId();
        this.user = postsLike.getUserId();
    }
}
