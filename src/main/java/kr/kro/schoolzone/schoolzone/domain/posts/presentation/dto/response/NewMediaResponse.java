package kr.kro.schoolzone.schoolzone.domain.posts.presentation.dto.response;

import kr.kro.schoolzone.schoolzone.domain.posts.domain.Media;
import lombok.Getter;

@Getter
public class NewMediaResponse {

    private final Long id;
    private final String changedName;

    public NewMediaResponse(Media media) {
        this.id = media.getId();
        this.changedName = media.getChangedName();
    }
}
