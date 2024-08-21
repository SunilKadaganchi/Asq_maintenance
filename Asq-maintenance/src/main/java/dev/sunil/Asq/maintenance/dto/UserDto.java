package dev.sunil.Asq.maintenance.dto;

import dev.sunil.Asq.maintenance.model.BankType;
import dev.sunil.Asq.maintenance.model.Question;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UserDto {
    private UUID userId;
    private String name;
    private String email;
    private long phoneNum;
    private BankType bankType;
    private List<Question> questionsList;
}
