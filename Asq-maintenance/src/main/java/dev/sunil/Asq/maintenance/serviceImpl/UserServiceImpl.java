package dev.sunil.Asq.maintenance.serviceImpl;

import dev.sunil.Asq.maintenance.Exception.EmailAlreadyExistException;
import dev.sunil.Asq.maintenance.Exception.InvalidCredentialsException;
import dev.sunil.Asq.maintenance.Exception.InvalidQuesAndAnswerDetails;
import dev.sunil.Asq.maintenance.Exception.UserNotFoundException;
import dev.sunil.Asq.maintenance.dto.LoginDto;
import dev.sunil.Asq.maintenance.dto.QNADto;
import dev.sunil.Asq.maintenance.dto.SignupDto;
import dev.sunil.Asq.maintenance.dto.UserDto;
import dev.sunil.Asq.maintenance.mapper.UserEntityDtoMapper;
import dev.sunil.Asq.maintenance.model.Question;
import dev.sunil.Asq.maintenance.model.User;
import dev.sunil.Asq.maintenance.repository.QuestionRepository;
import dev.sunil.Asq.maintenance.repository.UserRepository;
import dev.sunil.Asq.maintenance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public UserDto register(SignupDto signupDto) {
        Optional<User> user = userRepository.findByEmail(signupDto.getEmail());
        if(user.isPresent()){
            throw new EmailAlreadyExistException("Email Already Exists");
        }

        User saveuser = new User();
        saveuser.setName(signupDto.getName());
        saveuser.setEmail(signupDto.getEmail());
        saveuser.setPhoneNum(signupDto.getPhoneNum());
        saveuser.setPassword(signupDto.getPassword());

        saveuser= userRepository.save(saveuser);
        return UserEntityDtoMapper.convertEntityToDto(saveuser);
    }

    @Override
    public UserDto login(LoginDto loginDto) {
       User savedUser = userRepository.findByEmail(loginDto.getEmail()).orElseThrow(
               ()-> new InvalidCredentialsException("User with the given EmailId not exist"));

       if(!savedUser.getPassword().equals(loginDto.getPassword())){
           throw new InvalidCredentialsException("Password is Not matching");
       }

       return UserEntityDtoMapper.convertEntityToDto(savedUser);
    }

    @Override
    public UserDto getUserData(UUID id) {
        User user = userRepository.findById(id).orElseThrow(
                ()->new UserNotFoundException("User Not found with Id : "+id));
        if(user.getQuestionsList()==null || user.getQuestionsList().isEmpty()){
            user.setQuestionsList(new ArrayList<>());
        }

        return UserEntityDtoMapper.convertEntityToDto(user);
    }

    @Override
    public UserDto addEditQNA(UUID id, QNADto qnaDto) {
        User user = userRepository.findById(id).orElseThrow(
                ()->new UserNotFoundException("User Not found with Id : "+id));

        if(qnaDto.getQues1().isEmpty() || qnaDto.getQues1()==null ||
                qnaDto.getAns1().isEmpty() || qnaDto.getAns1()==null ||
                qnaDto.getQues2().isEmpty() || qnaDto.getQues2()==null ||
                qnaDto.getAns2().isEmpty() || qnaDto.getAns2()==null){
            throw new InvalidQuesAndAnswerDetails("User must contain 2 Question and Answers..");
        }

        Question q1 = new Question();
        q1.setQues(qnaDto.getQues1());
        q1.setAns(qnaDto.getAns1());
        q1=questionRepository.save(q1);

        Question q2 = new Question();
        q2.setQues(qnaDto.getQues2());
        q2.setAns(qnaDto.getAns2());
        q2= questionRepository.save(q2);

        List<Question> questions = user.getQuestionsList();
        if(questions==null || questions.isEmpty()){
            questions.add(q1);
            questions.add(q2);
        }
        else {
            questions.set(0, q1);
            questions.set(1, q2);
        }

        userRepository.save(user);

        return UserEntityDtoMapper.convertEntityToDto(user);
    }


    @Override
    public UserDto deleteQNA(UUID id) {
        User user = userRepository.findById(id).orElseThrow(
                ()->new UserNotFoundException("User Not found with Id : "+id));

        user.setQuestionsList(new ArrayList<>());
        return UserEntityDtoMapper.convertEntityToDto(userRepository.save(user));
    }
}
