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
    @Column(name = "comments_like_id")
    private Long commentsLikeId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "comments_id")
    private Comments commentsId;

    @Builder
    public CommentsLike(User userId, Comments commentsId) {
        this.userId = userId;
        this.commentsId = commentsId;
    }
}
