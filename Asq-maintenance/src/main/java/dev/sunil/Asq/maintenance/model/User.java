package dev.sunil.Asq.maintenance.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name="BANK_USER")
@Getter
@Setter
public class User extends BaseModel {
    private String name;
    private String email;
    private String password;
    private long phoneNum;
    @Enumerated(EnumType.STRING)
    private BankType bankType;
    @OneToOne
    private Question question;
}
