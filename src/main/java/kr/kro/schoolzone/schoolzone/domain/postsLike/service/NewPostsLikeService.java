package kr.kro.schoolzone.schoolzone.domain.postsLike.service;

import kr.kro.schoolzone.schoolzone.domain.posts.domain.Posts;
import kr.kro.schoolzone.schoolzone.domain.posts.service.GetPostsService;
import kr.kro.schoolzone.schoolzone.domain.postsLike.domain.PostsLike;
import kr.kro.schoolzone.schoolzone.domain.postsLike.presentation.dto.request.PostsLikeRequest;
import kr.kro.schoolzone.schoolzone.domain.postsLike.repository.PostsLikeRepository;
import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import kr.kro.schoolzone.schoolzone.domain.user.service.GetOneUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NewPostsLikeService {

    private final PostsLikeRepository postsLikeRepository;
    private final GetPostsService getPostsService;
    private final GetOneUserService getOneUserService;

    @Transactional
    public PostsLike execute(PostsLikeRequest request) {
        Posts posts = getPostsService.findPost(request.getPostsId());
        User user = getOneUserService.execute(request.getUserId());
        return postsLikeRepository.save(request.toEntity(posts, user));
    }
}
