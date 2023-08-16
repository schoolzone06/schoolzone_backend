package kr.kro.schoolzone.schoolzone.domain.replyCommentsLike.presentation.controller;

import kr.kro.schoolzone.schoolzone.domain.replyCommentsLike.domain.ReplyCommentsLike;
import kr.kro.schoolzone.schoolzone.domain.replyCommentsLike.presentation.dto.request.ReplyCommentsLikeRequest;
import kr.kro.schoolzone.schoolzone.domain.replyCommentsLike.service.DeleteReplyCommentsLikeService;
import kr.kro.schoolzone.schoolzone.domain.replyCommentsLike.service.GetReplyCommentsLikeCountService;
import kr.kro.schoolzone.schoolzone.domain.replyCommentsLike.service.NewReplyCommentsLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReplyCommentsLikeController {

    private final GetReplyCommentsLikeCountService getReplyCommentsLikeCountService;
    private final NewReplyCommentsLikeService newReplyCommentsLikeService;
    private final DeleteReplyCommentsLikeService deleteReplyCommentsLikeService;

    @GetMapping("/replyCommentsLike/{replyCommentsId}")
    public ResponseEntity<Integer> getReplyCommentsLikeCount(@PathVariable Long replyCommentsId) {
        return ResponseEntity.ok(getReplyCommentsLikeCountService.execute(replyCommentsId));
    }

    @PostMapping("/replyCommentsLike")
    public ResponseEntity<ReplyCommentsLike> newReplyCommentsLike(@RequestBody ReplyCommentsLikeRequest request) {
        return ResponseEntity.ok(newReplyCommentsLikeService.execute(request));
    }

    @DeleteMapping("/replyCommentsLike/{replyCommentsLikeId}")
    public ResponseEntity<Long> deleteReplyCommentsLike(@PathVariable Long replyCommentsLikeId) {
        return ResponseEntity.ok(deleteReplyCommentsLikeService.execute(replyCommentsLikeId));
    }
}
