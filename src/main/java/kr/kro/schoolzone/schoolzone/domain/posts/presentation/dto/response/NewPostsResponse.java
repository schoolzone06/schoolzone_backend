package kr.kro.schoolzone.schoolzone.domain.posts.presentation.dto.response;

import kr.kro.schoolzone.schoolzone.domain.posts.domain.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class NewPostsResponse {

    private Long userId;
    private Long postsId;
    private Category category;
    private String title;
    private String contents;
    private NewMediaResponse[] medias;
    private LocalDateTime createdAt;

    @Builder
    public NewPostsResponse(Long userId, Long postsId, Category category, String title, String contents, NewMediaResponse[] medias, LocalDateTime createdAt) {
        this.userId = userId;
        this.postsId = postsId;
        this.category = category;
        this.title = title;
        this.contents = contents;
        this.medias = medias;
        this.createdAt = createdAt;
    }
}
