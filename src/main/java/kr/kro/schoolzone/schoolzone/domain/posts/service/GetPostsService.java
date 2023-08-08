package kr.kro.schoolzone.schoolzone.domain.posts.service;

import kr.kro.schoolzone.schoolzone.domain.posts.Repository.PostsRepository;
import kr.kro.schoolzone.schoolzone.domain.posts.domain.Posts;
import kr.kro.schoolzone.schoolzone.domain.posts.presentation.dto.response.GetPostsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetPostsService {

    private final PostsRepository postsRepository;

    public List<GetPostsResponse> findAll() {
        return postsRepository.findAll().stream()
                .map(GetPostsResponse::new)
                .collect(Collectors.toList());
    }

    public GetPostsResponse findOne(Long id) {
        return new GetPostsResponse(postsRepository.findById(id).orElse(new Posts()));
    }
}
