package kr.or.changwon.changchang.changchang.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.or.changwon.changchang.changchang.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByStudentId(String studentId);
}
