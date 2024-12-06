package kr.or.changwon.changchang.changchang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.or.changwon.changchang.changchang.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long>{

    List<Notice> findByDepartmentId(Long departmentId);
    
}
