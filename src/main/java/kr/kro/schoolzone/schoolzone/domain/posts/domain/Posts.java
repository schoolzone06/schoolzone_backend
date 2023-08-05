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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Builder
    public Posts(User user, Category category, String title, String contents) {
        this.user = user;
        this.category = category;
        this.title = title;
        this.contents = contents;
    }
}
