package kr.kro.schoolzone.schoolzone.domain.comments.service;

import kr.kro.schoolzone.schoolzone.domain.comments.domain.Comments;
import kr.kro.schoolzone.schoolzone.domain.comments.presentation.dto.request.NewOrUpdateCommentsRequest;
import kr.kro.schoolzone.schoolzone.domain.comments.repository.CommentsRepository;
import kr.kro.schoolzone.schoolzone.domain.posts.domain.Posts;
import kr.kro.schoolzone.schoolzone.domain.posts.service.GetPostsService;
import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import kr.kro.schoolzone.schoolzone.domain.user.service.GetOneUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NewCommentsService {

    private final CommentsRepository commentsRepository;
    private final GetPostsService getPostsService;
    private final GetOneUserService getOneUserService;

    @Transactional
    public Comments execute(NewOrUpdateCommentsRequest request) {
        Posts postsId = getPostsService.findPost(request.getPostsId());
        User userId = getOneUserService.execute(request.getUserId());
        return commentsRepository.save(request.toEntity(userId, postsId));
    }
}
