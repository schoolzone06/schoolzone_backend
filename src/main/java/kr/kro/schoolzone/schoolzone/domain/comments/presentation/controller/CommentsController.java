package kr.kro.schoolzone.schoolzone.domain.comments.presentation.controller;

import kr.kro.schoolzone.schoolzone.domain.comments.domain.Comments;
import kr.kro.schoolzone.schoolzone.domain.comments.presentation.dto.request.NewOrUpdateCommentsRequest;
import kr.kro.schoolzone.schoolzone.domain.comments.presentation.dto.response.GetCommentsResponse;
import kr.kro.schoolzone.schoolzone.domain.comments.service.GetCommentsListService;
import kr.kro.schoolzone.schoolzone.domain.comments.service.NewCommentsRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentsController {

    private final GetCommentsListService getCommentsListService;
    private final NewCommentsRequestService newCommentsRequestService;

    @GetMapping("/comments/{postsId}")
    public ResponseEntity<List<GetCommentsResponse>> getComments(@PathVariable Long postsId) {
        return ResponseEntity.ok(getCommentsListService.execute(postsId));
    }

    @PostMapping("/comments")
    public ResponseEntity<Comments> newComments(@RequestBody NewOrUpdateCommentsRequest request) {
        return ResponseEntity.ok(newCommentsRequestService.execute(request));
    }
}
