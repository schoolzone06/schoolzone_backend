package kr.kro.schoolzone.schoolzone.domain.replyCommentsLike.service;

import kr.kro.schoolzone.schoolzone.domain.replyCommentsLike.repository.ReplyCommentsLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteReplyCommentsLikeService {

    private final ReplyCommentsLikeRepository replyCommentsLikeRepository;

    public Long execute(Long replyCommentsLikeId) {
        replyCommentsLikeRepository.deleteById(replyCommentsLikeId);
        return replyCommentsLikeId;
    }
}
