package kr.kro.schoolzone.schoolzone.domain.comments.service;

import kr.kro.schoolzone.schoolzone.domain.comments.domain.Comments;
import kr.kro.schoolzone.schoolzone.domain.comments.repository.CommentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetCommentsOneService {

    private final CommentsRepository commentsRepository;

    public Comments execute(Long commentsId) {
        return commentsRepository.findById(commentsId).orElse(new Comments());
    }
}
