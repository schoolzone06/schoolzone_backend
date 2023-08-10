package kr.kro.schoolzone.schoolzone.domain.comments.service;

import kr.kro.schoolzone.schoolzone.domain.comments.repository.CommentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCommentsService {

    private final CommentsRepository commentsRepository;

    public Long execute(Long commentsId) {
        commentsRepository.deleteById(commentsId);
        return commentsId;
    }
}
