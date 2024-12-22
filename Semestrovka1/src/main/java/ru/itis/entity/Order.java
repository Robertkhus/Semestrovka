package ru.itis.entity;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Order {
    private int id;
    private int userId;
    private String status;
    private Double totalPrice;
    private Date orderDate;
    private Date deliveryDate;
    private List<Product> products;
}
