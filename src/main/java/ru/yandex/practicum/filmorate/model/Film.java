package ru.yandex.practicum.filmorate.model;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.Duration;
import java.time.LocalDate;

@Data
public class Film {
    @NotNull(message = "ID can't be null")
    private long id;
    @NotEmpty(message = "Name can't be empty")
    private String name;
    @Size(max = 200, message = "Description should be shorter")
    private String description;
    @PastOrPresent(message = "Realise should be in past or in present")
    private LocalDate realise;
    @Positive(message = "Duration should be positive")
    private Duration duration;
}
