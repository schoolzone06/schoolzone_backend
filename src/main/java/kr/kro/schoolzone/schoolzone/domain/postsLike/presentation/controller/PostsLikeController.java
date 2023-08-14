package kr.kro.schoolzone.schoolzone.domain.postsLike.presentation.controller;

import kr.kro.schoolzone.schoolzone.domain.postsLike.domain.PostsLike;
import kr.kro.schoolzone.schoolzone.domain.postsLike.presentation.dto.request.PostsLikeRequest;
import kr.kro.schoolzone.schoolzone.domain.postsLike.presentation.dto.response.PostsLikeListResponse;
import kr.kro.schoolzone.schoolzone.domain.postsLike.service.DeletePostsLikeService;
import kr.kro.schoolzone.schoolzone.domain.postsLike.service.GetPostsLikeService;
import kr.kro.schoolzone.schoolzone.domain.postsLike.service.NewPostsLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostsLikeController {

    private final GetPostsLikeService getPostsLikeService;
    private final NewPostsLikeService newPostsLikeService;
    private final DeletePostsLikeService deletePostsLikeService;

    @GetMapping("/postsLike/list/{postsId}")
    public ResponseEntity<List<PostsLikeListResponse>> getPostsLikeList(@PathVariable Long postsId) {
        return ResponseEntity.ok(getPostsLikeService.getList(postsId));
    }

    @GetMapping("/postsLike/count/{postsId}")
    public ResponseEntity<Integer> getPostsLikeCount(@PathVariable Long postsId) {
        return ResponseEntity.ok(getPostsLikeService.getCount(postsId));
    }

    @PostMapping("/postsLike")
    public ResponseEntity<PostsLike> newPostsLike(@RequestBody PostsLikeRequest request) {
        return ResponseEntity.ok(newPostsLikeService.execute(request));
    }

    @DeleteMapping("/postsLike/{postsLikeId}")
    public ResponseEntity<Long> deletePostsLike(@PathVariable Long postsLikeId) {
        return ResponseEntity.ok(deletePostsLikeService.execute(postsLikeId));
    }
}
