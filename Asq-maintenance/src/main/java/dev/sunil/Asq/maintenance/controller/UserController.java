package dev.sunil.Asq.maintenance.controller;

import dev.sunil.Asq.maintenance.dto.LoginDto;
import dev.sunil.Asq.maintenance.dto.QNADto;
import dev.sunil.Asq.maintenance.dto.SignupDto;
import dev.sunil.Asq.maintenance.dto.UserDto;
import dev.sunil.Asq.maintenance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(@RequestBody SignupDto signupDto){
        return new ResponseEntity<>(userService.register(signupDto),HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginDto loginDto){
        return new ResponseEntity<>(userService.login(loginDto),HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserData(@PathVariable("id") UUID id){
        return new ResponseEntity<>(userService.getUserData(id), HttpStatus.OK);
    }

    @PostMapping("/addEdit/{id}")
    public  ResponseEntity<UserDto> addEditQNA(@PathVariable("id") UUID id, @RequestBody QNADto qnaDto){
        return new ResponseEntity<>(userService.addEditQNA(id,qnaDto),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> deleteQNA(@PathVariable("id") UUID id){
        return new ResponseEntity<>(userService.deleteQNA(id),HttpStatus.OK);
    }
}
