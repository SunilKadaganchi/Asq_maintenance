package dev.sunil.Asq.maintenance.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name="USER_QNA")
@Getter
@Setter
public class Question extends BaseModel {
    private String ques;
    private String ans;
}
