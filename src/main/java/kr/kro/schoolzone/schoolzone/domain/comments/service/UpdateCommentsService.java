package kr.kro.schoolzone.schoolzone.domain.comments.service;

import kr.kro.schoolzone.schoolzone.domain.comments.domain.Comments;
import kr.kro.schoolzone.schoolzone.domain.comments.presentation.dto.request.NewOrUpdateCommentsRequest;
import kr.kro.schoolzone.schoolzone.domain.comments.repository.CommentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateCommentsService {

    private final CommentsRepository commentsRepository;

    @Transactional
    public Comments execute(Long commentsId, NewOrUpdateCommentsRequest request) {
        Comments updatedComments = commentsRepository.findById(commentsId).orElse(new Comments()).update(request);
        return commentsRepository.save(updatedComments);
    }
}
