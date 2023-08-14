package kr.kro.schoolzone.schoolzone.domain.postsLike.presentation.controller;

import kr.kro.schoolzone.schoolzone.domain.postsLike.presentation.dto.response.PostsLikeListResponse;
import kr.kro.schoolzone.schoolzone.domain.postsLike.service.GetPostsLikeListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostsLikeController {

    private final GetPostsLikeListService getPostsLikeListService;

    @GetMapping("/postsLike/list/{postsId}")
    public ResponseEntity<List<PostsLikeListResponse>> getPostsLikeList(@PathVariable Long postsId) {
        return ResponseEntity.ok(getPostsLikeListService.execute(postsId));
    }
}
