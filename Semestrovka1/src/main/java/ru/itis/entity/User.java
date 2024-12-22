package ru.itis.entity;

import lombok.*;

import java.util.UUID;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String role;
    private UUID session_id;
}

