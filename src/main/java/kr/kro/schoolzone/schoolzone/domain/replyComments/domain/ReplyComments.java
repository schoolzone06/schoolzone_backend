package kr.kro.schoolzone.schoolzone.domain.replyComments.domain;

import jakarta.persistence.*;
import kr.kro.schoolzone.schoolzone.domain.comments.domain.Comments;
import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class ReplyComments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_comments_id")
    private Long replyCommentsId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @ManyToOne
    @JoinColumn(name = "comments_id", nullable = false)
    private Comments commentsId;

    @Column(nullable = false)
    private String contents;

    @Builder
    public ReplyComments(User userId, Comments commentsId, String contents) {
        this.userId = userId;
        this.commentsId = commentsId;
        this.contents = contents;
    }
}
