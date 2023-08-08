package kr.kro.schoolzone.schoolzone.domain.posts.presentation.dto.request;

import kr.kro.schoolzone.schoolzone.domain.posts.domain.Category;
import lombok.Getter;

@Getter
public class UpdatePostsRequest {

    private String title;
    private String contents;
    private Category category;
}
