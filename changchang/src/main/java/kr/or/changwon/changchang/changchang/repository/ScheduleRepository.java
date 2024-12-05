package kr.or.changwon.changchang.changchang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.or.changwon.changchang.changchang.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>{

    void deleteAllBySubjectId(Long id);
    
}
