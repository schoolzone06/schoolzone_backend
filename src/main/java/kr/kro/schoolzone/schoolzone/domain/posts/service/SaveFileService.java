package kr.kro.schoolzone.schoolzone.domain.posts.service;

import kr.kro.schoolzone.schoolzone.domain.posts.domain.File;
import kr.kro.schoolzone.schoolzone.domain.posts.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SaveFileService {

    private final FileRepository fileRepository;
    private final GetPostsService getPostsService;

    @Transactional
    public File[] execute(MultipartFile[] files, Long postsId) {
        return saveFileData(files, postsId);
    }

    private File[] saveFileData(MultipartFile[] files, Long postsId) {
        File[] result = new File[files.length];
        int idx = 0;

        for (MultipartFile file : files) {
            String fileName = file.getResource().getFilename();
            result[idx++] = fileRepository.save(
                    File.builder()
                        .file(getPostsService.findPost(postsId))
                        .originalName(fileName)
                        .changedName(UUID.randomUUID().toString() + "_" + fileName)
                        .size(file.getSize())
                        .build()
            );
        }

        return result;
    }
}
