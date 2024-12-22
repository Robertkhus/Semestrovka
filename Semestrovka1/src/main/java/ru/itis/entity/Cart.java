package ru.itis.entity;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Cart {
    private int id;
    private int userId;
    private int productId;
    private int quantity;
}
