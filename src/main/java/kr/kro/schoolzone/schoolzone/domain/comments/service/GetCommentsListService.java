package kr.kro.schoolzone.schoolzone.domain.comments.service;

import kr.kro.schoolzone.schoolzone.domain.comments.presentation.dto.response.GetCommentsResponse;
import kr.kro.schoolzone.schoolzone.domain.comments.repository.CommentsRepository;
import kr.kro.schoolzone.schoolzone.domain.posts.domain.Posts;
import kr.kro.schoolzone.schoolzone.domain.posts.service.GetPostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetCommentsListService {

    private final CommentsRepository commentsRepository;
    private final GetPostsService getPostsService;

    public List<GetCommentsResponse> execute(Long postsId) {

        return commentsRepository.findByPostsId(getPostsService.findPost(postsId)).stream()
                .map(GetCommentsResponse::new)
                .collect(Collectors.toList());
    }
}
