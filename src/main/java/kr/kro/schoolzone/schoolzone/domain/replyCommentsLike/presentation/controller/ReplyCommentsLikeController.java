package kr.kro.schoolzone.schoolzone.domain.replyCommentsLike.presentation.controller;

import kr.kro.schoolzone.schoolzone.domain.replyCommentsLike.service.GetReplyCommentsLikeCountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReplyCommentsLikeController {

    private final GetReplyCommentsLikeCountService getReplyCommentsLikeCountService;

    @GetMapping("/replyCommentsLike/{replyCommentsId}")
    public ResponseEntity<Integer> getReplyCommentsLikeCount(@PathVariable Long replyCommentsId) {
        return ResponseEntity.ok(getReplyCommentsLikeCountService.execute(replyCommentsId));
    }
}
