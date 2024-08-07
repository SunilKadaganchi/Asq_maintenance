package dev.sunil.Asq.maintenance.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Question extends BaseModel{
    private String quesOne;
    private String ansOne;
    private String quesTwo;
    private String ansTwo;
}
