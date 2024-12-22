package ru.itis.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Review {
    private int id;
    private int userId;
    private int productId;
    private String comment;
    private Date reviewDate;
}
