package kr.kro.schoolzone.schoolzone.domain.replyComments.service;

import kr.kro.schoolzone.schoolzone.domain.replyComments.domain.ReplyComments;
import kr.kro.schoolzone.schoolzone.domain.replyComments.repository.ReplyCommentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetReplyCommentsOneService {

    private final ReplyCommentsRepository replyCommentsRepository;

    public ReplyComments execute(Long replyCommentsId) {
        return replyCommentsRepository.findById(replyCommentsId).orElse(new ReplyComments());
    }
}
