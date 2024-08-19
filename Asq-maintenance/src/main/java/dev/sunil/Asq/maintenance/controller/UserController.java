package dev.sunil.Asq.maintenance.controller;

import dev.sunil.Asq.maintenance.dto.QNADto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    public ResponseEntity getUserData(@PathVariable("id") UUID id){

        return null;
    }

    @PostMapping("/{id}")
    public  ResponseEntity addQNA(@PathVariable("id") UUID id,@RequestBody QNADto qnaDto){

        return null;
    }

    @PostMapping("/{id}")
    public ResponseEntity editQNA(@PathVariable("id") UUID id,@RequestBody QNADto qnaDto){

        return  null;
    }

    @DeleteMapping("/id")
    public ResponseEntity deleteQNA(@PathVariable("id") UUID id){

        return null;
    }
}
