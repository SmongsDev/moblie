package kr.or.changwon.changchang.changchang.DTO;

import kr.or.changwon.changchang.changchang.entity.AssignmentStatus;
import lombok.Getter;

@Getter
public class AssignmentStatusDTO {
    // private Long id;
    private String subjectName; // 과목명
    private boolean submitted; // 과제 제출 여부
    private String deadline; // 마감일

    public AssignmentStatusDTO(AssignmentStatus assignmentStatus) {
        // this.id = assignmentStatus.getId();
        this.subjectName = assignmentStatus.getSubject().getName();
        this.submitted = assignmentStatus.isSubmitted();
        this.deadline = assignmentStatus.getDeadline();
    }
}
