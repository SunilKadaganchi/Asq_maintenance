package dev.sunil.Asq.maintenance.mapper;

import dev.sunil.Asq.maintenance.dto.UserDto;
import dev.sunil.Asq.maintenance.model.User;

public class UserEntityDtoMapper {

    public static UserDto convertEntityToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPhoneNum(user.getPhoneNum());
        userDto.setBankType(user.getBankType());
        userDto.setQuestionsList(user.getQuestionsList());

        return userDto;
    }

}
