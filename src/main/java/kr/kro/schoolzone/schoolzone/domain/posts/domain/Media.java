package kr.kro.schoolzone.schoolzone.domain.posts.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "posts_id")
    @ManyToOne
    private Posts posts;

    @Column(nullable = false)
    private String originalName;

    @Column(nullable = false)
    private String changedName;

    @Column(nullable = false)
    private Long size;

    @Builder
    public Media(Posts posts, String originalName, String changedName, Long size) {
        this.posts = posts;
        this.originalName = originalName;
        this.changedName = changedName;
        this.size = size;
    }
}
