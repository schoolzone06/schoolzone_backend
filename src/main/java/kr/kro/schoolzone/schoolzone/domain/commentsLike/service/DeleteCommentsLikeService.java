package kr.kro.schoolzone.schoolzone.domain.commentsLike.service;

import kr.kro.schoolzone.schoolzone.domain.commentsLike.repository.CommentsLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCommentsLikeService {

    private final CommentsLikeRepository commentsLikeRepository;

    public Long execute(Long commentsLikeId) {
        commentsLikeRepository.deleteById(commentsLikeId);
        return commentsLikeId;
    }
}
