package kr.kro.schoolzone.schoolzone.domain.posts.presentation.controller;

import kr.kro.schoolzone.schoolzone.domain.posts.domain.File;
import kr.kro.schoolzone.schoolzone.domain.posts.service.GetPostsService;
import kr.kro.schoolzone.schoolzone.domain.posts.service.SaveFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/files")
public class FilesController {

    private final SaveFileService saveFileService;
    private final GetPostsService getPostsService;

    @PostMapping
    public ResponseEntity<File[]> save(@RequestParam("post_id") Long postId,
                                     @RequestParam("file") MultipartFile[] files) {
        return ResponseEntity.ok(saveFileService.execute(files, getPostsService.findPost(postId).getPostsId()));
    }
}
