package ru.yandex.practicum.filmorate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.Film;


import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class FilmController {
    private final Map<Long, Film> map = new HashMap<>();

    @GetMapping("/films")
    public List<Film> findAllUsers() {
        return (List<Film>) map.values();
    }

    @PostMapping("/film")
    public void create(@Validated @RequestBody Film film, HttpServletRequest request) {
        log.info("Получен запрос к эндпоинту: '{} {}', Строка параметров запроса: '{}'",
                request.getMethod(), request.getRequestURI(), request.getQueryString());
        if(film.getRealise().isBefore(LocalDate.of(1895,12,28))){
            throw new ValidationException("Era of films starts 28Dec1895 ");
        }
        map.put(film.getId(), film);
    }

    @PutMapping("/film")
    public void update(@Validated @RequestBody Film film, HttpServletRequest request) {
        log.info("Получен запрос к эндпоинту: '{} {}', Строка параметров запроса: '{}'",
                request.getMethod(), request.getRequestURI(), request.getQueryString());
        map.put(film.getId(), film);
    }
}
