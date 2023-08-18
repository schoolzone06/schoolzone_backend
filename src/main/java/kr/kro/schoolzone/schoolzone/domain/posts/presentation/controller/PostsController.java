package kr.kro.schoolzone.schoolzone.domain.posts.presentation.controller;

import kr.kro.schoolzone.schoolzone.domain.posts.domain.Posts;
import kr.kro.schoolzone.schoolzone.domain.posts.presentation.dto.request.NewPostsRequest;
import kr.kro.schoolzone.schoolzone.domain.posts.presentation.dto.request.UpdatePostsRequest;
import kr.kro.schoolzone.schoolzone.domain.posts.presentation.dto.response.GetPostsResponse;
import kr.kro.schoolzone.schoolzone.domain.posts.service.DeletePostsService;
import kr.kro.schoolzone.schoolzone.domain.posts.service.GetPostsService;
import kr.kro.schoolzone.schoolzone.domain.posts.service.NewPostsService;
import kr.kro.schoolzone.schoolzone.domain.posts.service.UpdatePostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostsController {

    private final GetPostsService getPostsService;
    private final NewPostsService newPostsService;
    private final UpdatePostsService updatePostsService;
    private final DeletePostsService deletePostsService;

    @GetMapping
    public ResponseEntity<List<GetPostsResponse>> getPosts() {
        return ResponseEntity.ok(getPostsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetPostsResponse> getPost(@PathVariable Long id) {
        return ResponseEntity.ok(getPostsService.findOne(id));
    }

    @PostMapping
    public ResponseEntity<Posts> newPosts(@RequestBody NewPostsRequest request) {
        return ResponseEntity.ok(newPostsService.execute(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Posts> updatePosts(@PathVariable Long id,
                                             @RequestBody UpdatePostsRequest request) {
        return ResponseEntity.ok(updatePostsService.execute(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deletePosts(@PathVariable Long id) {
        return ResponseEntity.ok(deletePostsService.execute(id));
    }
}
