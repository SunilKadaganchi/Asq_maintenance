package dev.sunil.Asq.maintenance.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupDto {
    private String name;
    private long phoneNum;
    private String email;
    private String password;
}
