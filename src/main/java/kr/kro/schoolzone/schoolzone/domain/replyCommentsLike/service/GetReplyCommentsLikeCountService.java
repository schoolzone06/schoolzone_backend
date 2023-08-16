package kr.kro.schoolzone.schoolzone.domain.replyCommentsLike.service;

import kr.kro.schoolzone.schoolzone.domain.replyComments.domain.ReplyComments;
import kr.kro.schoolzone.schoolzone.domain.replyComments.service.GetReplyCommentsOneService;
import kr.kro.schoolzone.schoolzone.domain.replyCommentsLike.repository.ReplyCommentsLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetReplyCommentsLikeCountService {

    private final ReplyCommentsLikeRepository replyCommentsLikeRepository;
    private final GetReplyCommentsOneService getReplyCommentsOneService;

    public Integer execute(Long replyCommentsId) {
        ReplyComments replyComments = getReplyCommentsOneService.execute(replyCommentsId);
        return replyCommentsLikeRepository.findByReplyCommentsId(replyComments).size();
    }
}
