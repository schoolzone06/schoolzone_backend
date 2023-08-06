package kr.kro.schoolzone.schoolzone.domain.posts.presentation.controller;

import kr.kro.schoolzone.schoolzone.domain.posts.domain.Posts;
import kr.kro.schoolzone.schoolzone.domain.posts.presentation.dto.request.NewPostsRequest;
import kr.kro.schoolzone.schoolzone.domain.posts.presentation.dto.response.PostsResponse;
import kr.kro.schoolzone.schoolzone.domain.posts.service.GetPostsService;
import kr.kro.schoolzone.schoolzone.domain.posts.service.NewPostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostsController {

    private final GetPostsService getPostsService;
    private final NewPostsService newPostsService;

    @GetMapping("/posts")
    public ResponseEntity<List<PostsResponse>> getPosts() {
        return ResponseEntity.ok(getPostsService.findAll());
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<PostsResponse> getPost(@PathVariable Long id) {
        return ResponseEntity.ok(getPostsService.findOne(id));
    }

    @PostMapping("/posts")
    public ResponseEntity<Posts> newPosts(@RequestBody NewPostsRequest request) {
        return ResponseEntity.ok(newPostsService.execute(request));
    }
}
