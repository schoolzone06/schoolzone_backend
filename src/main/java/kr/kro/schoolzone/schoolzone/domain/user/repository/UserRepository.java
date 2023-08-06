package kr.kro.schoolzone.schoolzone.domain.user.repository;

import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
