package kr.kro.schoolzone.schoolzone.domain.postsLike.service;

import kr.kro.schoolzone.schoolzone.domain.postsLike.repository.PostsLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePostsLikeService {

    private final PostsLikeRepository postsLikeRepository;

    public Long execute(Long postsLikeId) {
        postsLikeRepository.deleteById(postsLikeId);
        return postsLikeId;
    }
}
