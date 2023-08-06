package kr.kro.schoolzone.schoolzone.domain.postsLike.domain;

import jakarta.persistence.*;
import kr.kro.schoolzone.schoolzone.domain.posts.domain.Posts;
import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class PostsLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "posts_like_id")
    private Long postsLikeId;

    @OneToOne
    @JoinColumn(name = "posts_id")
    private Posts postsId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @Builder
    public PostsLike(Posts postsId, User userId) {
        this.postsId = postsId;
        this.userId = userId;
    }
}
