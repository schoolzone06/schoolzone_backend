package kr.kro.schoolzone.schoolzone.domain.replyCommentsLike.service;

import kr.kro.schoolzone.schoolzone.domain.replyComments.domain.ReplyComments;
import kr.kro.schoolzone.schoolzone.domain.replyComments.service.GetReplyCommentsOneService;
import kr.kro.schoolzone.schoolzone.domain.replyCommentsLike.presentation.dto.response.ReplyCommentsLikeResponse;
import kr.kro.schoolzone.schoolzone.domain.replyCommentsLike.repository.ReplyCommentsLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetReplyCommentsLikeCountService {

    private final ReplyCommentsLikeRepository replyCommentsLikeRepository;
    private final GetReplyCommentsOneService getReplyCommentsOneService;

    public List<ReplyCommentsLikeResponse> execute(Long replyCommentsId) {
        ReplyComments replyComments = getReplyCommentsOneService.execute(replyCommentsId);
        return replyCommentsLikeRepository.findByReplyCommentsId(replyComments).stream()
                .map(ReplyCommentsLikeResponse::new)
                .collect(Collectors.toList());
    }
}
