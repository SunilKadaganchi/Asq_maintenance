package dev.sunil.Asq.maintenance.mapper;

import dev.sunil.Asq.maintenance.dto.QnAResponseDto;
import dev.sunil.Asq.maintenance.dto.UserDto;
import dev.sunil.Asq.maintenance.model.Question;
import dev.sunil.Asq.maintenance.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserEntityDtoMapper {

    public static UserDto convertEntityToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPhoneNum(user.getPhoneNum());
        userDto.setBankType(user.getBankType());
        List<QnAResponseDto> qnAResponseDtoList = new ArrayList<>();
        if(user.getQuestionsList()!=null && !user.getQuestionsList().isEmpty() ){
            for(Question qna : user.getQuestionsList()){
                QnAResponseDto q = new QnAResponseDto();
                q.setQuestion(qna.getQues());
                q.setAnswer(qna.getAns());
                qnAResponseDtoList.add(q);
            }
        }
        userDto.setQuestionsList(qnAResponseDtoList);
        return userDto;
    }

}
