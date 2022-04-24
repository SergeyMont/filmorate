package ru.yandex.practicum.filmorate.model;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class User {
    @NotNull(message="ID can't be null")
    private long id;
    @NotEmpty(message = "Email can't be empty")
    @Email(message = "Enter correct email format")
    private String email;
    @NotEmpty(message = "Login can't be empty")
    @NotBlank(message = "Delete blank")
    private String login;
    private String name;
    @Past(message = "You can't birth in future")
    private LocalDate birth;
}
