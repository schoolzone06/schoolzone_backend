package kr.kro.schoolzone.schoolzone.domain.commentsLike.presentation.controller;

import kr.kro.schoolzone.schoolzone.domain.commentsLike.domain.CommentsLike;
import kr.kro.schoolzone.schoolzone.domain.commentsLike.presentation.dto.request.CommentsLikeRequest;
import kr.kro.schoolzone.schoolzone.domain.commentsLike.service.GetCommentsLikeCountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentsLikeController {

    private final GetCommentsLikeCountService getCommentsLikeCountService;

    @GetMapping("/commentsLike/{commentsId}")
    public ResponseEntity<Integer> getCommentsLikeCount(@PathVariable Long commentsId) {
        return ResponseEntity.ok(getCommentsLikeCountService.execute(commentsId));
    }
}
