package kr.or.changwon.changchang.changchang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.or.changwon.changchang.changchang.entity.ToDo;

public interface TodoRepository extends JpaRepository<ToDo, Long>{

    List<ToDo> findByUserId(Long id);
    
}
