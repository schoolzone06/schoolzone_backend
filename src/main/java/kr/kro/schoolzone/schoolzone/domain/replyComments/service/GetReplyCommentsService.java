package kr.kro.schoolzone.schoolzone.domain.replyComments.service;

import kr.kro.schoolzone.schoolzone.domain.comments.service.GetCommentsOneService;
import kr.kro.schoolzone.schoolzone.domain.replyComments.presentation.dto.response.GetReplyCommentsResponse;
import kr.kro.schoolzone.schoolzone.domain.replyComments.repository.ReplyCommentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetReplyCommentsService {

    private final ReplyCommentsRepository replyCommentsRepository;
    private final GetCommentsOneService getCommentsOneService;

    public List<GetReplyCommentsResponse> execute(Long commentsId) {
        return replyCommentsRepository.findByCommentsId(getCommentsOneService.execute(commentsId)).stream()
                .map(GetReplyCommentsResponse::new)
                .collect(Collectors.toList());
    }
}
