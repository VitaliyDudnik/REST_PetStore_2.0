package com.example.restapi_lesson_42.resource;

import com.example.restapi_lesson_42.entity.Token;
import com.example.restapi_lesson_42.entity.User;
import com.example.restapi_lesson_42.service.TokenService;
import com.example.restapi_lesson_42.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final TokenService tokenService;

    public UserController(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody User user) {
        User userSave = userService.save(user);
        Token token = new Token();
        token.setUser(userSave);
        token.setUuid(UUID.randomUUID());
        Token save = tokenService.save(token);
        return new ResponseEntity<>(save, HttpStatus.OK);

    }

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/getByUsername")
    public User getUserByUsername(String username) {
        return userService.getUserByUsername(username);
    }

    @PutMapping("/updateUsername")
    public ResponseEntity<User> updateUsername(long id, String username) {
        userService.updateUsername(id, username);
        User updatedUser = userService.getUserByUsername(username);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestHeader(name = "X-Token") UUID xToken, String username, String password) {
        User userByUsername = userService.getUserByUsername(username);
        if (userByUsername.getPassword().equals(password)) {
            return new ResponseEntity<>(xToken, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/logout")
    public void logout(@RequestHeader(name = "X-Token") UUID xToken) {
        Optional<Token> tokenByUUID = tokenService.findTokenByUUID(xToken);
        tokenService.delete(tokenByUUID.get());
    }
}

