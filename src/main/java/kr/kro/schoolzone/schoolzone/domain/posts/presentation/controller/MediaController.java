package kr.kro.schoolzone.schoolzone.domain.posts.presentation.controller;

import kr.kro.schoolzone.schoolzone.domain.posts.domain.Media;
import kr.kro.schoolzone.schoolzone.domain.posts.service.GetPostsService;
import kr.kro.schoolzone.schoolzone.domain.posts.service.SaveFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/media")
public class MediaController {

    private final SaveFileService saveFileService;
    private final GetPostsService getPostsService;

    @PostMapping
    public ResponseEntity<Media[]> save(@RequestParam("post_id") Long postId,
                                        @RequestParam("file") MultipartFile[] media) throws IOException {
        return ResponseEntity.ok(saveFileService.execute(media, getPostsService.findPost(postId).getPostsId()));
    }
}
