package ru.yandex.practicum.catsgram.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class User {
    private String email;
    private String nickname;
    private LocalDate birthdate;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d,MM,yyyy");

    public User(String email, String nickname, String birthdate) {
        this.email = email;
        this.nickname = nickname;
        this.birthdate = LocalDate.parse(birthdate, formatter);
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}