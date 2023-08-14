package kr.kro.schoolzone.schoolzone.domain.postsLike.repository;

import kr.kro.schoolzone.schoolzone.domain.posts.domain.Posts;
import kr.kro.schoolzone.schoolzone.domain.postsLike.domain.PostsLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsLikeRepository extends JpaRepository<PostsLike, Long> {

    List<PostsLike> findByPostsId(Posts postsId);
}
