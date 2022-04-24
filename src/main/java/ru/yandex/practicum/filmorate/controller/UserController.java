package ru.yandex.practicum.filmorate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class UserController {
    private final Map<Long, User> map = new HashMap<>();

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return (List<User>) map.values();
    }

    @PostMapping("/user")
    public void create(@Validated @RequestBody User user, HttpServletRequest request) {
        log.info("Получен запрос к эндпоинту: '{} {}', Строка параметров запроса: '{}'",
                request.getMethod(), request.getRequestURI(), request.getQueryString());
        if(user.getName().isEmpty()){
            user.setName(user.getLogin());
        }
        map.put(user.getId(), user);
    }

    @PutMapping("/user")
    public void update(@Validated @RequestBody User user, HttpServletRequest request) {
        log.info("Получен запрос к эндпоинту: '{} {}', Строка параметров запроса: '{}'",
                request.getMethod(), request.getRequestURI(), request.getQueryString());
        map.put(user.getId(), user);
    }
}
