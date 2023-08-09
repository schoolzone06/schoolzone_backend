package kr.kro.schoolzone.schoolzone.domain.posts.service;

import kr.kro.schoolzone.schoolzone.domain.posts.repository.PostsRepository;
import kr.kro.schoolzone.schoolzone.domain.posts.domain.Posts;
import kr.kro.schoolzone.schoolzone.domain.posts.presentation.dto.request.NewPostsRequest;
import kr.kro.schoolzone.schoolzone.domain.user.service.GetOneUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NewPostsService {

    private final GetOneUserService getOneUserService;
    private final PostsRepository postsRepository;

    @Transactional
    public Posts execute(NewPostsRequest request) {
        return postsRepository.save(request.toEntity(getOneUserService.execute(request.getUser())));
    }
}
