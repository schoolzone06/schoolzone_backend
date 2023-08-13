package kr.kro.schoolzone.schoolzone.domain.replyComments.service;

import kr.kro.schoolzone.schoolzone.domain.replyComments.repository.ReplyCommentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteReplyCommentsService {

    private final ReplyCommentsRepository replyCommentsRepository;

    public Long execute(Long replyCommentsId) {
        replyCommentsRepository.deleteById(replyCommentsId);
        return replyCommentsId;
    }
}
