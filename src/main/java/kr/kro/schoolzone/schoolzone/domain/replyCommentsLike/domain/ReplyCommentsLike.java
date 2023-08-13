package kr.kro.schoolzone.schoolzone.domain.replyCommentsLike.domain;

import jakarta.persistence.*;
import kr.kro.schoolzone.schoolzone.domain.replyComments.domain.ReplyComments;
import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class ReplyCommentsLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_comments_like_id")
    private Long replyCommentsLikeId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @OneToOne
    @JoinColumn(name = "reply_comments_id", nullable = false)
    private ReplyComments replyCommentsId;

    @Builder
    public ReplyCommentsLike(User userId, ReplyComments replyCommentsId) {
        this.userId = userId;
        this.replyCommentsId = replyCommentsId;
    }
}
