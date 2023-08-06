package kr.kro.schoolzone.schoolzone.domain.posts.service;

import kr.kro.schoolzone.schoolzone.domain.posts.Repository.PostsRepository;
import kr.kro.schoolzone.schoolzone.domain.posts.domain.Posts;
import kr.kro.schoolzone.schoolzone.domain.posts.presentation.dto.response.PostsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetPostsService {

    private final PostsRepository postsRepository;

    public List<PostsResponse> findAll() {
        return postsRepository.findAll().stream()
                .map(PostsResponse::new)
                .collect(Collectors.toList());
    }

    public PostsResponse findOne(Long id) {
        return new PostsResponse(postsRepository.findById(id).orElse(new Posts()));
    }
}
