package kr.kro.schoolzone.schoolzone.domain.posts.service;

import kr.kro.schoolzone.schoolzone.domain.posts.Repository.PostsRepository;
import kr.kro.schoolzone.schoolzone.domain.posts.presentation.dto.response.PostsAllResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetPostsService {

    private final PostsRepository postsRepository;

    public List<PostsAllResponse> findAll() {
        return postsRepository.findAll().stream()
                .map(PostsAllResponse::new)
                .collect(Collectors.toList());
    }
}
