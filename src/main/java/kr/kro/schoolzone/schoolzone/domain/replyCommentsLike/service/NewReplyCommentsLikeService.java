package kr.kro.schoolzone.schoolzone.domain.replyCommentsLike.service;

import kr.kro.schoolzone.schoolzone.domain.replyComments.domain.ReplyComments;
import kr.kro.schoolzone.schoolzone.domain.replyComments.service.GetReplyCommentsOneService;
import kr.kro.schoolzone.schoolzone.domain.replyCommentsLike.domain.ReplyCommentsLike;
import kr.kro.schoolzone.schoolzone.domain.replyCommentsLike.presentation.dto.request.ReplyCommentsLikeRequest;
import kr.kro.schoolzone.schoolzone.domain.replyCommentsLike.repository.ReplyCommentsLikeRepository;
import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import kr.kro.schoolzone.schoolzone.domain.user.service.GetOneUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NewReplyCommentsLikeService {

    private final ReplyCommentsLikeRepository replyCommentsLikeRepository;
    private final GetOneUserService getOneUserService;
    private final GetReplyCommentsOneService getReplyCommentsOneService;

    @Transactional
    public ReplyCommentsLike execute(ReplyCommentsLikeRequest request) {
        User user = getOneUserService.execute(request.getUserId());
        ReplyComments replyComments = getReplyCommentsOneService.execute(request.getReplyCommentsId());
        return replyCommentsLikeRepository.save(request.toEntity(user, replyComments));
    }
}
