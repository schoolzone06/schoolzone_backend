package kr.kro.schoolzone.schoolzone.domain.comments.presentation.controller;

import kr.kro.schoolzone.schoolzone.domain.comments.presentation.dto.response.GetCommentsResponse;
import kr.kro.schoolzone.schoolzone.domain.comments.service.GetCommentsListService;
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
public class CommentsController {

    private final GetCommentsListService getCommentsListService;

    @GetMapping("/comments/{postsId}")
    public ResponseEntity<List<GetCommentsResponse>> getComments(@PathVariable Long postsId) {
        return ResponseEntity.ok(getCommentsListService.execute(postsId));
    }
}
