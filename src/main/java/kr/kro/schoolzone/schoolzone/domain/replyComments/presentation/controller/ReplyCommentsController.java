package kr.kro.schoolzone.schoolzone.domain.replyComments.presentation.controller;

import kr.kro.schoolzone.schoolzone.domain.replyComments.domain.ReplyComments;
import kr.kro.schoolzone.schoolzone.domain.replyComments.presentation.dto.request.NewReplyCommentsRequest;
import kr.kro.schoolzone.schoolzone.domain.replyComments.presentation.dto.response.GetReplyCommentsResponse;
import kr.kro.schoolzone.schoolzone.domain.replyComments.service.GetReplyCommentsService;
import kr.kro.schoolzone.schoolzone.domain.replyComments.service.NewReplyCommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReplyCommentsController {

    private final GetReplyCommentsService getReplyCommentsService;
    private final NewReplyCommentsService newReplyCommentsService;

    @GetMapping("/replyComments/{commentsId}")
    public ResponseEntity<List<GetReplyCommentsResponse>> getReplyComments(@PathVariable Long commentsId) {
        return ResponseEntity.ok(getReplyCommentsService.execute(commentsId));
    }

    @PostMapping("/replyComments")
    public ResponseEntity<ReplyComments> newReplyComments(@RequestBody NewReplyCommentsRequest request) {
        return ResponseEntity.ok(newReplyCommentsService.execute(request));
    }
}
