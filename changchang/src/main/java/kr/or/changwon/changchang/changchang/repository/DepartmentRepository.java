package kr.or.changwon.changchang.changchang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.or.changwon.changchang.changchang.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}