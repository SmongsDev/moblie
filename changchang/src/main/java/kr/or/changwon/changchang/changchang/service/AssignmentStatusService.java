package kr.or.changwon.changchang.changchang.service;

import kr.or.changwon.changchang.changchang.DTO.AssignmentStatusDTO;
import kr.or.changwon.changchang.changchang.DTO.requestDTO.RequestAssignmentDTO;
import kr.or.changwon.changchang.changchang.entity.AssignmentStatus;
import kr.or.changwon.changchang.changchang.entity.Subject;
import kr.or.changwon.changchang.changchang.entity.User;
import kr.or.changwon.changchang.changchang.repository.AssignmentStatusRepository;
import kr.or.changwon.changchang.changchang.repository.SubjectRepository;
import kr.or.changwon.changchang.changchang.repository.UserRepository;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignmentStatusService {
    private final UserRepository userRepository;
    private final SubjectRepository subjectRepository;
    private final AssignmentStatusRepository assignmentStatusRepository;

    public AssignmentStatusService(UserRepository userRepository, SubjectRepository subjectRepository, AssignmentStatusRepository assignmentStatusRepository) {
        this.userRepository = userRepository;
        this.subjectRepository = subjectRepository;
        this.assignmentStatusRepository = assignmentStatusRepository;
    }

    public List<AssignmentStatusDTO> getAssignmentsByStudentId(String studentId) {
        User user = userRepository.findByStudentId(studentId)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
        List<AssignmentStatus> assignmentStatus = assignmentStatusRepository.findByUserId(user.getId());
        return assignmentStatus.stream()
            .map(AssignmentStatusDTO::new)
            .collect(Collectors.toList());
    }

    // 특정 사용자에 대한 과제 제출 여부 조회
    public List<AssignmentStatus> getAssignmentsWithStatus(String studentId) {
        User user = userRepository.findByStudentId(studentId)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
        
        return user.getAssignmentStatuses();
    }
    
    @Transactional
    public void addAssignment(RequestAssignmentDTO requestDto){
        User user = userRepository.findByStudentId(requestDto.getStudentId())
            .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Subject subject = subjectRepository.findByName(requestDto.getSubjectName())
            .orElseThrow(() -> new IllegalArgumentException("Subject not found"));

        // if (assignmentStatusRepository.existsByUserAndSubject(user, subject)) {
        //     throw new IllegalStateException("Assignment status already exists for this user and subject.");
        // }

        AssignmentStatus assignmentStatus = new AssignmentStatus();
        assignmentStatus.setUser(user);
        assignmentStatus.setSubject(subject);
        assignmentStatus.setSubmitted(false);
        assignmentStatus.setDeadline(requestDto.getDeadline());

        assignmentStatusRepository.save(assignmentStatus);
    }

    // 과제 삭제
    @Transactional
    public void deleteAssignment(Long assignmentId){
        AssignmentStatus assignment = assignmentStatusRepository.findById(assignmentId)
            .orElseThrow(() -> new IllegalArgumentException("Assignment not found"));
        assignmentStatusRepository.delete(assignment);
    }
}
