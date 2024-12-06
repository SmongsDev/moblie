package kr.or.changwon.changchang.changchang.controller;

import kr.or.changwon.changchang.changchang.DTO.AssignmentStatusDTO;
import kr.or.changwon.changchang.changchang.DTO.requestDTO.RequestAssignmentDTO;
import kr.or.changwon.changchang.changchang.service.AssignmentStatusService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/assignment")
public class AssignmentStatusController {
    private final AssignmentStatusService assignmentStatusService;

    public AssignmentStatusController(AssignmentStatusService assignmentStatusService) {
        this.assignmentStatusService = assignmentStatusService;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<List<AssignmentStatusDTO>> getUserAssignments(@PathVariable String studentId) {
        List<AssignmentStatusDTO> res = assignmentStatusService.getAssignmentsByStudentId(studentId);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUserAssignment(@RequestBody RequestAssignmentDTO requestDto) {
        assignmentStatusService.addAssignment(requestDto); 
        return ResponseEntity.ok("적용 완료");
    }

    @DeleteMapping("/{assignmentId}")
    public ResponseEntity<String> deleteAssignment(@PathVariable Long assignmentId){
        assignmentStatusService.deleteAssignment(assignmentId);
        return ResponseEntity.ok("과제 삭제 정공");
    }

}
