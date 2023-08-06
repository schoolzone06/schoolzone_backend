package kr.kro.schoolzone.schoolzone.domain.posts.domain;

import jakarta.persistence.*;
import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import kr.kro.schoolzone.schoolzone.global.entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "posts_id")
    private Long postsId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Builder
    public Posts(User userId, Category category, String title, String contents) {
        this.userId = userId;
        this.category = category;
        this.title = title;
        this.contents = contents;
    }
}
