package dev.sunil.Asq.maintenance.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionHandlerDto {
    private String meesage;
    private int code;

    public ExceptionHandlerDto(String meesage, int code) {
        this.meesage = meesage;
        this.code = code;
    }
}
