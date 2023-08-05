package kr.kro.schoolzone.schoolzone.domain.commentsLike.domain;

import jakarta.persistence.*;
import kr.kro.schoolzone.schoolzone.domain.comments.domain.Comments;
import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class CommentsLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "comments_id")
    private Comments comments;

    @Builder
    public CommentsLike(User user, Comments comments) {
        this.user = user;
        this.comments = comments;
    }
}
