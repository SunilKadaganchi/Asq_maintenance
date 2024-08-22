package dev.sunil.Asq.maintenance.service;

import dev.sunil.Asq.maintenance.dto.LoginDto;
import dev.sunil.Asq.maintenance.dto.QNADto;
import dev.sunil.Asq.maintenance.dto.SignupDto;
import dev.sunil.Asq.maintenance.dto.UserDto;
import dev.sunil.Asq.maintenance.model.User;

import java.util.UUID;

public interface UserService {

     UserDto register(SignupDto signupDto);
     String login(LoginDto loginDto);
     UserDto getUserData(UUID id);
     UserDto addEditQNA(UUID id, QNADto qnaDto);
     UserDto deleteQNA(UUID id);
}
