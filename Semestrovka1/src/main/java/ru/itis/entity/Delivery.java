package ru.itis.entity;

import lombok.*;

import java.util.Date;




@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Delivery {

    private int id;
    private int orderId;
    private String deliveryAddress;
    private String status;
    private String trackingNumber;
    private Date deliveryDate;
}
