package kr.kro.schoolzone.schoolzone.domain.postsLike.presentation.controller;

import kr.kro.schoolzone.schoolzone.domain.postsLike.presentation.dto.response.PostsLikeListResponse;
import kr.kro.schoolzone.schoolzone.domain.postsLike.service.GetPostsLikeService;
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

    private final GetPostsLikeService getPostsLikeService;

    @GetMapping("/postsLike/list/{postsId}")
    public ResponseEntity<List<PostsLikeListResponse>> getPostsLikeList(@PathVariable Long postsId) {
        return ResponseEntity.ok(getPostsLikeService.getList(postsId));
    }

    @GetMapping("/postsLike/count/{postsId}")
    public ResponseEntity<Integer> getPostsLikeCount(@PathVariable Long postsId) {
        return ResponseEntity.ok(getPostsLikeService.getCount(postsId));
    }
}
