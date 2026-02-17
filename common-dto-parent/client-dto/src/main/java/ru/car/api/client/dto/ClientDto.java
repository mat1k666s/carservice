package ru.car.api.client.dto;

import lombok.Data;
import ru.car.api.client.ClientStatus;


import java.time.LocalDate;

@Data
public class ClientDto {
    private Integer id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String phone;
    private String email;
    private String address;
    private ClientStatus status;
    private LocalDate createdAt;



}
