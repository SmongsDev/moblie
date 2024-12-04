package kr.or.changwon.changchang.changchang.service;

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

    public List<AssignmentStatus> getAssignmentsByUserId(Long userId) {
        return assignmentStatusRepository.findByUserId(userId);
    }


    // 특정 사용자에게 과제 생성
    public void createAssignmentForUser(Long userId, String subjectName) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Subject subject = subjectRepository.findByName(subjectName)
                .orElseThrow(() -> new IllegalArgumentException("Subject not found"));

        AssignmentStatus assignmentStatus = new AssignmentStatus();
        assignmentStatus.setUser(user);
        assignmentStatus.setSubject(subject);
        assignmentStatus.setSubmitted(false);

        assignmentStatusRepository.save(assignmentStatus);
    }

    // 특정 사용자에 대한 과제 제출 여부 조회
    public List<AssignmentStatus> getAssignmentsWithStatus(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
        
        return user.getAssignmentStatuses();
    }
    
    @Transactional
    public void addAssignment(RequestAssignmentDTO requestDto){
        User user = userRepository.findById(requestDto.getUserId())
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

        assignmentStatusRepository.save(assignmentStatus);
    }
}
