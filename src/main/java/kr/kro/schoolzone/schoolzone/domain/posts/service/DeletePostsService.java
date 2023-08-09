package kr.kro.schoolzone.schoolzone.domain.posts.service;

import kr.kro.schoolzone.schoolzone.domain.posts.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeletePostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long execute(Long id) {
        postsRepository.deleteById(id);
        return id;
    }
}
