package ru.yandex.practicum.catsgram.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.User;
import ru.yandex.practicum.catsgram.service.UserService;

import java.util.Collection;

@Slf4j
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public Collection<User> findAll() {
        log.debug("Запрос всех пользователей!");
        return userService.findAll();
    }

    @GetMapping("/user/{userEmail}")
    @ResponseBody
    public User findByEmail(@PathVariable String email) {
        log.info("Запрос пользователя по email");
        return userService.findByEmail(email);
    }

    @PostMapping(value = "/user")
    public User create(@RequestBody User user) {
        log.debug("Добавление нового пользователя!");
        return userService.createUser(user);
    }
}
