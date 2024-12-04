package kr.or.changwon.changchang.changchang.DTO;

import kr.or.changwon.changchang.changchang.entity.Subject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDTO {
    private String subjectName;
    private String scheduleInfo;
    private boolean assignmentSubmitted;

    public SubjectDTO(Subject subject, boolean assignmentSubmitted) {
        this.subjectName = subject.getName();
        this.scheduleInfo = subject.getScheduleInfo();
        this.assignmentSubmitted = assignmentSubmitted;
    }
}
