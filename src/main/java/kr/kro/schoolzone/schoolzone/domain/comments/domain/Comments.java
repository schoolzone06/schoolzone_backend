package kr.kro.schoolzone.schoolzone.domain.comments.domain;

import jakarta.persistence.*;
import kr.kro.schoolzone.schoolzone.domain.posts.domain.Posts;
import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import kr.kro.schoolzone.schoolzone.global.entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Comments extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "posts_id")
    private Posts posts;

    @Column(nullable = false)
    private String contents;

    @Builder
    public Comments(User user, Posts posts, String contents) {
        this.user = user;
        this.posts = posts;
        this.contents = contents;
    }
}
