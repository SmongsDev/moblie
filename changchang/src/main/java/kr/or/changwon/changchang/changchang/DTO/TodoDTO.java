package kr.or.changwon.changchang.changchang.DTO;

import kr.or.changwon.changchang.changchang.entity.ToDo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoDTO {
    private Long id;
    private String content;
    private String studentId;

    public TodoDTO() {
    }

    public TodoDTO(ToDo todo) {
        this.id = todo.getId();
        this.content = todo.getContent();
    }

}
