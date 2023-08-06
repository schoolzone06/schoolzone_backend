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
    @Column(name = "comments_id")
    private Long commentsId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "posts_id")
    private Posts postsId;

    @Column(nullable = false)
    private String contents;

    @Builder
    public Comments(User userId, Posts postsId, String contents) {
        this.userId = userId;
        this.postsId = postsId;
        this.contents = contents;
    }
}
