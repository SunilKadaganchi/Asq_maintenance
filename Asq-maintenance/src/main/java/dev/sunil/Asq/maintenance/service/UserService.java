package dev.sunil.Asq.maintenance.service;

import dev.sunil.Asq.maintenance.dto.QNADto;
import dev.sunil.Asq.maintenance.dto.UserDataDto;

import java.util.UUID;

public interface UserService {
    public UserDataDto getUserData(UUID id);
    public UserDataDto addQNA(UUID id, QNADto qnaDto);
    public UserDataDto editQNA(UUID id, QNADto qnaDto);
    public UserDataDto deleteQNA(UUID id);
}
