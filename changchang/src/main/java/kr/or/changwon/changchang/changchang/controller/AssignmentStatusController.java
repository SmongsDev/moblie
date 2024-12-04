package kr.or.changwon.changchang.changchang.controller;

import kr.or.changwon.changchang.changchang.DTO.AssignmentStatusDTO;
import kr.or.changwon.changchang.changchang.DTO.requestDTO.RequestAssignmentDTO;
import kr.or.changwon.changchang.changchang.service.AssignmentStatusService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/assignments")
public class AssignmentStatusController {
    private final AssignmentStatusService assignmentStatusService;

    public AssignmentStatusController(AssignmentStatusService assignmentStatusService) {
        this.assignmentStatusService = assignmentStatusService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<AssignmentStatusDTO>> getUserAssignments(@PathVariable Long userId) {
        List<AssignmentStatusDTO> res = assignmentStatusService.getAssignmentsByUserId(userId)
            .stream()
            .map(AssignmentStatusDTO::new)
            .collect(Collectors.toList());

        return ResponseEntity.ok(res);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUserAssignment(@RequestBody RequestAssignmentDTO requestDto) {
        assignmentStatusService.addAssignment(requestDto); 
        return ResponseEntity.ok("적용 완료");
    }

}
