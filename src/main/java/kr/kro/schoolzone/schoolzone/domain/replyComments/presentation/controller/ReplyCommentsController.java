package kr.kro.schoolzone.schoolzone.domain.replyComments.presentation.controller;

import kr.kro.schoolzone.schoolzone.domain.replyComments.domain.ReplyComments;
import kr.kro.schoolzone.schoolzone.domain.replyComments.presentation.dto.request.NewReplyCommentsRequest;
import kr.kro.schoolzone.schoolzone.domain.replyComments.presentation.dto.request.UpdateReplyCommentsRequest;
import kr.kro.schoolzone.schoolzone.domain.replyComments.presentation.dto.response.GetReplyCommentsResponse;
import kr.kro.schoolzone.schoolzone.domain.replyComments.service.DeleteReplyCommentsService;
import kr.kro.schoolzone.schoolzone.domain.replyComments.service.GetReplyCommentsService;
import kr.kro.schoolzone.schoolzone.domain.replyComments.service.NewReplyCommentsService;
import kr.kro.schoolzone.schoolzone.domain.replyComments.service.UpdateReplyCommentsService;
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
    private final UpdateReplyCommentsService updateReplyCommentsService;
    private final DeleteReplyCommentsService deleteReplyCommentsService;

    @GetMapping("/replyComments/{commentsId}")
    public ResponseEntity<List<GetReplyCommentsResponse>> getReplyComments(@PathVariable Long commentsId) {
        return ResponseEntity.ok(getReplyCommentsService.execute(commentsId));
    }

    @PostMapping("/replyComments")
    public ResponseEntity<ReplyComments> newReplyComments(@RequestBody NewReplyCommentsRequest request) {
        return ResponseEntity.ok(newReplyCommentsService.execute(request));
    }

    @PutMapping("/replyComments/{replyCommentsId}")
    public ResponseEntity<ReplyComments> updateReplyComments(@PathVariable Long replyCommentsId,
                                                             @RequestBody UpdateReplyCommentsRequest request) {
        return ResponseEntity.ok(updateReplyCommentsService.execute(replyCommentsId, request));
    }

    @DeleteMapping("/replyComments/{replyCommentsId}")
    public ResponseEntity<Long> deleteReplyComments(@PathVariable Long replyCommentsId) {
        return ResponseEntity.ok(deleteReplyCommentsService.execute(replyCommentsId));
    }
}
