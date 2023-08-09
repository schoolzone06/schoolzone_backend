package kr.kro.schoolzone.schoolzone.domain.posts.service;

import kr.kro.schoolzone.schoolzone.domain.posts.repository.PostsRepository;
import kr.kro.schoolzone.schoolzone.domain.posts.domain.Posts;
import kr.kro.schoolzone.schoolzone.domain.posts.presentation.dto.request.UpdatePostsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePostsService {

    private final PostsRepository postsRepository;

    public Posts execute(Long id, UpdatePostsRequest request) {
        Posts posts = postsRepository.findById(id).orElse(new Posts());
        return postsRepository.save(posts.update(request));
    }
}
