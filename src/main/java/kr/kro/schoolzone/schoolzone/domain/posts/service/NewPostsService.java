package kr.kro.schoolzone.schoolzone.domain.posts.service;

import kr.kro.schoolzone.schoolzone.domain.posts.domain.Media;
import kr.kro.schoolzone.schoolzone.domain.posts.presentation.dto.response.NewMediaResponse;
import kr.kro.schoolzone.schoolzone.domain.posts.presentation.dto.response.NewPostsResponse;
import kr.kro.schoolzone.schoolzone.domain.posts.repository.PostsRepository;
import kr.kro.schoolzone.schoolzone.domain.posts.domain.Posts;
import kr.kro.schoolzone.schoolzone.domain.posts.presentation.dto.request.NewPostsRequest;
import kr.kro.schoolzone.schoolzone.domain.user.service.GetOneUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class NewPostsService {

    private final GetOneUserService getOneUserService;
    private final PostsRepository postsRepository;
    private final SaveMediaService saveMediaService;

    @Transactional
    public NewPostsResponse execute(NewPostsRequest request, MultipartFile[] media) throws IOException {
        Posts posts = postsRepository.save(request.toEntity(getOneUserService.execute(request.getUser())));
        NewMediaResponse[] savedMedia = saveMediaService.execute(media, posts.getPostsId());
        return NewPostsResponse.builder()
                .userId(posts.getUserId().getUserId())
                .postsId(posts.getPostsId())
                .category(posts.getCategory())
                .title(posts.getTitle())
                .contents(posts.getContents())
                .medias(savedMedia)
                .createdAt(posts.getCreatedTime())
                .build();
    }
}
