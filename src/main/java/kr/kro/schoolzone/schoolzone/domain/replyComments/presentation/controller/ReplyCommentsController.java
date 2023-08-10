package kr.kro.schoolzone.schoolzone.domain.replyComments.presentation.controller;

import kr.kro.schoolzone.schoolzone.domain.replyComments.presentation.dto.response.GetReplyCommentsResponse;
import kr.kro.schoolzone.schoolzone.domain.replyComments.service.GetReplyCommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReplyCommentsController {

    private final GetReplyCommentsService getReplyCommentsService;

    @GetMapping("/replyComments/{commentsId}")
    public ResponseEntity<List<GetReplyCommentsResponse>> getReplyComments(@PathVariable Long commentsId) {
        return ResponseEntity.ok(getReplyCommentsService.execute(commentsId));
    }
}
