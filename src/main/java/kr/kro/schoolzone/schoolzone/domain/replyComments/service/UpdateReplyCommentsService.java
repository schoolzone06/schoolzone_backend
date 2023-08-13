package kr.kro.schoolzone.schoolzone.domain.replyComments.service;

import kr.kro.schoolzone.schoolzone.domain.replyComments.domain.ReplyComments;
import kr.kro.schoolzone.schoolzone.domain.replyComments.presentation.dto.request.UpdateReplyCommentsRequest;
import kr.kro.schoolzone.schoolzone.domain.replyComments.repository.ReplyCommentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateReplyCommentsService {

    private final ReplyCommentsRepository replyCommentsRepository;

    @Transactional
    public ReplyComments execute(Long replyCommentsId, UpdateReplyCommentsRequest request) {
        ReplyComments replyComments = replyCommentsRepository.findById(replyCommentsId).orElse(new ReplyComments());
        return replyCommentsRepository.save(replyComments.update(request));
    }
}
