package dev.sunil.Asq.maintenance.serviceImpl;

import dev.sunil.Asq.maintenance.dto.QNADto;
import dev.sunil.Asq.maintenance.dto.UserDataDto;
import dev.sunil.Asq.maintenance.service.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDataDto getUserData(UUID id) {
        return null;
    }

    @Override
    public UserDataDto addQNA(UUID id, QNADto qnaDto) {
        return null;
    }

    @Override
    public UserDataDto editQNA(UUID id, QNADto qnaDto) {
        return null;
    }

    @Override
    public UserDataDto deleteQNA(UUID id) {
        return null;
    }
}
