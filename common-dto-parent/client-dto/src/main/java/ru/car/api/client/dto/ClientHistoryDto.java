package ru.car.api.client.dto;

import lombok.Data;
import ru.car.api.client.InteractionType;
import ru.car.api.client.entity.ClientEntity;


import java.time.LocalDateTime;

@Data
public class ClientHistoryDto {
    private Integer id;
    private Integer clientId;
    private String clientName;
    private InteractionType type;
    private ClientEntity clientEntity;
    private LocalDateTime registrationDate;


}
