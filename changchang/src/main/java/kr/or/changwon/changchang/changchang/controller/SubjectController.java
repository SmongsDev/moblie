package kr.or.changwon.changchang.changchang.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.changwon.changchang.changchang.DTO.SubjectDTO;
import kr.or.changwon.changchang.changchang.entity.Subject;
import kr.or.changwon.changchang.changchang.service.SubjectService;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    // Subject 생성
    @PostMapping
    public ResponseEntity<Subject> createSubject(@RequestBody SubjectDTO subjectDTO) {
        Subject createdSubject = subjectService.createSubject(subjectDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSubject);
    }

    // 특정 Subject 조회
    @GetMapping("/{subjectId}")
    public ResponseEntity<SubjectDTO> getSubjectById(@PathVariable Long subjectId) {
        SubjectDTO subject = subjectService.getSubjectById(subjectId);
        return ResponseEntity.ok(subject);
    }

    // 모든 Subject 조회
    @GetMapping
    public ResponseEntity<List<SubjectDTO>> getAllSubjects() {
        List<SubjectDTO> subjects = subjectService.getAllSubjects();
        return ResponseEntity.ok(subjects);
    }

    // Subject 업데이트
    @PutMapping("/{subjectId}")
    public ResponseEntity<String> updateSubject(@PathVariable Long subjectId, @RequestBody SubjectDTO subjectDTO) {
        subjectService.updateSubject(subjectId, subjectDTO);
        return ResponseEntity.ok("강의가 업데이트 되었습니다.");
    }

    // Subject 삭제
    @DeleteMapping("/{subjectId}")
    public ResponseEntity<String> deleteSubject(@PathVariable Long subjectId) {
        subjectService.deleteSubject(subjectId);
        return ResponseEntity.ok("강의가 삭제되었습니다.");
    }
}
