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
    private Long id;

    @OneToOne
    @JoinColumn(name = "posts_id")
    private Posts posts;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public PostsLike(Posts posts, User user) {
        this.posts = posts;
        this.user = user;
    }
}
