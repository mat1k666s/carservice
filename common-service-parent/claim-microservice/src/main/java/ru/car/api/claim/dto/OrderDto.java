package ru.car.api.claim.dto;

import lombok.Data;

@Data
public class OrderDto {
    private Integer id;
    private String fullName;
    private String phone;
    private String email;


}
