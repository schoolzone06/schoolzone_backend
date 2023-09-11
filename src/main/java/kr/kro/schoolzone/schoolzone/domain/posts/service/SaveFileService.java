package kr.kro.schoolzone.schoolzone.domain.posts.service;

import kr.kro.schoolzone.schoolzone.domain.posts.domain.Media;
import kr.kro.schoolzone.schoolzone.domain.posts.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SaveFileService {

    private final FileRepository fileRepository;
    private final GetPostsService getPostsService;;

    @Transactional
    public Media[] execute(MultipartFile[] media, Long postsId) throws IOException {
        return saveFileData(media, postsId);
    }

    private Media[] saveFileData(MultipartFile[] media, Long postsId) throws IOException {
        Media[] result = new Media[media.length];
        int idx = 0;

        for (MultipartFile v : media) {
            String fileName = v.getResource().getFilename();
            result[idx++] = fileRepository.save(
                    Media.builder()
                        .file(getPostsService.findPost(postsId))
                        .originalName(fileName)
                        .changedName(UUID.randomUUID().toString() + "_" + fileName)
                        .size(v.getSize())
                        .build()
            );
        }

        return result;
    }
}
