package kr.or.changwon.changchang.changchang.DTO.ResponseDTO;

import kr.or.changwon.changchang.changchang.entity.Subject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseSubjectDTO {
    private String name;
    private String scheduleInfo;

    public ResponseSubjectDTO(Subject subject) {
        this.name = subject.getName();
    }
}
