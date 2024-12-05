package kr.or.changwon.changchang.changchang.DTO;

import java.util.List;
import java.util.stream.Collectors;

import kr.or.changwon.changchang.changchang.entity.Subject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDTO {
    private String subjectName;
    private List<ScheduleDTO> schedules;


    public SubjectDTO(Subject subject) {
        this.subjectName = subject.getName();
        
        this.schedules = subject.getSchedules().stream()
                .map(ScheduleDTO::new)
                .collect(Collectors.toList());
    }
}
