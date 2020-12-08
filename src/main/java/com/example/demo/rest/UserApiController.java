package com.example.demo.rest;

import com.example.demo.dto.LoginDto;
import com.example.demo.repository.Type;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    private final UserService userService;

    public UserApiController() {
        userService = new UserService();
    }

    @PostMapping("/api/users/login")
    public ResponseEntity<Void> login(@RequestBody LoginDto loginDto) {

        Type status = userService.checkLogin(loginDto.getLogin(), loginDto.getPassword());

        switch (status) {
            case FailureLogin:
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            case IncorrectLoginCounter:
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            case SuccessfulLogin:
                return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
