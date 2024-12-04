package kr.or.changwon.changchang.changchang.DTO.requestDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestCreateUserDTO {
    private Long id;
    private String username;
    private String password;

    public RequestCreateUserDTO(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
