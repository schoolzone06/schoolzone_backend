package kr.kro.schoolzone.schoolzone.domain.postsLike.service;

import kr.kro.schoolzone.schoolzone.domain.posts.service.GetPostsService;
import kr.kro.schoolzone.schoolzone.domain.postsLike.presentation.dto.response.PostsLikeListResponse;
import kr.kro.schoolzone.schoolzone.domain.postsLike.repository.PostsLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetPostsLikeService {

    private final PostsLikeRepository postsLikeRepository;
    private final GetPostsService getPostsService;

    public List<PostsLikeListResponse> getList(Long postsId) {
        return postsLikeRepository.findByPostsId(getPostsService.findPost(postsId)).stream()
                .map(PostsLikeListResponse::new)
                .collect(Collectors.toList());
    }
}
