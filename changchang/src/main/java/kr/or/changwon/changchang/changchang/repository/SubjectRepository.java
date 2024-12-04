package kr.or.changwon.changchang.changchang.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.or.changwon.changchang.changchang.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{
    Optional<Subject> findByName(String subjectName);
    
}
