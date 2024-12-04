package kr.or.changwon.changchang.changchang.DTO.requestDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestAssignmentDTO {
    private Long userId;
    private String subjectName; // 과목명
    private String deadline; // 마감일
}
