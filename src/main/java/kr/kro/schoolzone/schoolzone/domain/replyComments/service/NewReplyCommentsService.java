package kr.kro.schoolzone.schoolzone.domain.replyComments.service;

import kr.kro.schoolzone.schoolzone.domain.comments.domain.Comments;
import kr.kro.schoolzone.schoolzone.domain.comments.service.GetCommentsOneService;
import kr.kro.schoolzone.schoolzone.domain.replyComments.domain.ReplyComments;
import kr.kro.schoolzone.schoolzone.domain.replyComments.presentation.dto.request.NewReplyCommentsRequest;
import kr.kro.schoolzone.schoolzone.domain.replyComments.repository.ReplyCommentsRepository;
import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import kr.kro.schoolzone.schoolzone.domain.user.service.GetOneUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewReplyCommentsService {

    private final ReplyCommentsRepository replyCommentsRepository;
    private final GetOneUserService getOneUserService;
    private final GetCommentsOneService getCommentsOneService;

    public ReplyComments execute(NewReplyCommentsRequest request) {
        User user = getOneUserService.execute(request.getUserId());
        Comments comments = getCommentsOneService.execute(request.getCommentsId());
        return replyCommentsRepository.save(request.toEntity(user, comments));
    }
}
