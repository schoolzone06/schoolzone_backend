package kr.kro.schoolzone.schoolzone.domain.commentsLike.service;

import kr.kro.schoolzone.schoolzone.domain.comments.domain.Comments;
import kr.kro.schoolzone.schoolzone.domain.comments.service.GetCommentsOneService;
import kr.kro.schoolzone.schoolzone.domain.commentsLike.repository.CommentsLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetCommentsLikeCountService {

    private final CommentsLikeRepository commentsLikeRepository;
    private final GetCommentsOneService getCommentsOneService;

    public Integer execute(Long commentsId) {
        Comments comments = getCommentsOneService.execute(commentsId);
        return commentsLikeRepository.findByCommentsId(comments).toArray().length;
    }
}
