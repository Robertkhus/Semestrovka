package ru.itis.entity;

import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class Product {
    private int id;
    private String name;
    private String description;
    private Double price;
    private String size;
    private int  category_id;
    private List<Order> orders;
}
