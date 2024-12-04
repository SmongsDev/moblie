package kr.or.changwon.changchang.changchang.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kr.or.changwon.changchang.changchang.entity.Subject;
import kr.or.changwon.changchang.changchang.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByStudentId(String studentId);
    
    @Query("SELECT u.subjects FROM User u WHERE u.id = :userId")
    List<Subject> findSubjectsByUserId(@Param("userId") Long userId);
}
