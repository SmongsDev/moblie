package kr.or.changwon.changchang.changchang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import kr.or.changwon.changchang.changchang.entity.AssignmentStatus;

import java.util.List;

public interface AssignmentStatusRepository extends JpaRepository<AssignmentStatus, Long> {
    List<AssignmentStatus> findByUserId(Long userId);

}
