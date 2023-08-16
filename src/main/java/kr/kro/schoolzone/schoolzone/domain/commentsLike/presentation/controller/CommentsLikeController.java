package kr.kro.schoolzone.schoolzone.domain.commentsLike.presentation.controller;

import kr.kro.schoolzone.schoolzone.domain.commentsLike.domain.CommentsLike;
import kr.kro.schoolzone.schoolzone.domain.commentsLike.presentation.dto.request.CommentsLikeRequest;
import kr.kro.schoolzone.schoolzone.domain.commentsLike.presentation.dto.response.CommentsLikeResponse;
import kr.kro.schoolzone.schoolzone.domain.commentsLike.service.DeleteCommentsLikeService;
import kr.kro.schoolzone.schoolzone.domain.commentsLike.service.GetCommentsLikeCountService;
import kr.kro.schoolzone.schoolzone.domain.commentsLike.service.NewCommentsLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentsLikeController {

    private final GetCommentsLikeCountService getCommentsLikeCountService;
    private final NewCommentsLikeService newCommentsLikeService;
    private final DeleteCommentsLikeService deleteCommentsLikeService;

    @GetMapping("/commentsLike/{commentsId}")
    public ResponseEntity<List<CommentsLikeResponse>> getCommentsLikeCount(@PathVariable Long commentsId) {
        return ResponseEntity.ok(getCommentsLikeCountService.execute(commentsId));
    }

    @PostMapping("/commentsLike")
    public ResponseEntity<CommentsLike> newCommentsLike(@RequestBody CommentsLikeRequest request) {
        return ResponseEntity.ok(newCommentsLikeService.execute(request));
    }

    @DeleteMapping("/commentsLike/{commentsLikeId}")
    public ResponseEntity<Long> deleteCommentsLike(@PathVariable Long commentsLikeId) {
        return ResponseEntity.ok(deleteCommentsLikeService.execute(commentsLikeId));
    }
}
