package kr.kro.schoolzone.schoolzone.domain.commentsLike.service;

import kr.kro.schoolzone.schoolzone.domain.comments.domain.Comments;
import kr.kro.schoolzone.schoolzone.domain.comments.service.GetCommentsOneService;
import kr.kro.schoolzone.schoolzone.domain.commentsLike.presentation.dto.response.CommentsLikeResponse;
import kr.kro.schoolzone.schoolzone.domain.commentsLike.repository.CommentsLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetCommentsLikeCountService {

    private final CommentsLikeRepository commentsLikeRepository;
    private final GetCommentsOneService getCommentsOneService;

    public List<CommentsLikeResponse> execute(Long commentsId) {
        Comments comments = getCommentsOneService.execute(commentsId);
        return commentsLikeRepository.findByCommentsId(comments).stream()
                .map(CommentsLikeResponse::new)
                .collect(Collectors.toList());
    }
}
