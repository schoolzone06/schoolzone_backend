package kr.kro.schoolzone.schoolzone.domain.comments.presentation.controller;

import kr.kro.schoolzone.schoolzone.domain.comments.domain.Comments;
import kr.kro.schoolzone.schoolzone.domain.comments.presentation.dto.request.NewOrUpdateCommentsRequest;
import kr.kro.schoolzone.schoolzone.domain.comments.presentation.dto.response.GetCommentsResponse;
import kr.kro.schoolzone.schoolzone.domain.comments.service.DeleteCommentsService;
import kr.kro.schoolzone.schoolzone.domain.comments.service.GetCommentsListService;
import kr.kro.schoolzone.schoolzone.domain.comments.service.NewCommentsService;
import kr.kro.schoolzone.schoolzone.domain.comments.service.UpdateCommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentsController {

    private final GetCommentsListService getCommentsListService;
    private final NewCommentsService newCommentsService;
    private final UpdateCommentsService updateCommentsService;
    private final DeleteCommentsService deleteCommentsService;

    @GetMapping("/{postsId}")
    public ResponseEntity<List<GetCommentsResponse>> getComments(@PathVariable Long postsId) {
        return ResponseEntity.ok(getCommentsListService.execute(postsId));
    }

    @PostMapping
    public ResponseEntity<Comments> newComments(@RequestBody NewOrUpdateCommentsRequest request) {
        return ResponseEntity.ok(newCommentsService.execute(request));
    }

    @PutMapping("/{commentsId}")
    public ResponseEntity<Comments> updateComments(@PathVariable Long commentsId,
                                                   @RequestBody NewOrUpdateCommentsRequest request) {
        return ResponseEntity.ok(updateCommentsService.execute(commentsId, request));
    }

    @DeleteMapping("/{commentsId}")
    public ResponseEntity<Long> deleteComments(@PathVariable Long commentsId) {
        return ResponseEntity.ok(deleteCommentsService.execute(commentsId));
    }
}
