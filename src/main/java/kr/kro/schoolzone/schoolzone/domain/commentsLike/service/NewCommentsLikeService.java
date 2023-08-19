package kr.kro.schoolzone.schoolzone.domain.commentsLike.service;

import kr.kro.schoolzone.schoolzone.domain.comments.domain.Comments;
import kr.kro.schoolzone.schoolzone.domain.comments.service.GetCommentsOneService;
import kr.kro.schoolzone.schoolzone.domain.commentsLike.domain.CommentsLike;
import kr.kro.schoolzone.schoolzone.domain.commentsLike.presentation.dto.request.CommentsLikeRequest;
import kr.kro.schoolzone.schoolzone.domain.commentsLike.repository.CommentsLikeRepository;
import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import kr.kro.schoolzone.schoolzone.domain.user.service.GetOneUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NewCommentsLikeService {

    private final CommentsLikeRepository commentsLikeRepository;
    private final GetOneUserService getOneUserService;
    private final GetCommentsOneService getCommentsOneService;

    @Transactional
    public CommentsLike execute(CommentsLikeRequest request) {
        User user = getOneUserService.execute(request.getUserId());
        Comments comments = getCommentsOneService.execute(request.getCommentsId());
        return commentsLikeRepository.save(request.toEntity(user, comments));
    }
}
