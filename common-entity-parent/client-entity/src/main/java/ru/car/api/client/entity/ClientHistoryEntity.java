package ru.car.api.client.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.car.api.client.InteractionType;


import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client_history", schema = "client")
public class ClientHistoryEntity implements Serializable {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "client_name")
    private String clientName;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private InteractionType type;
    @Column(name = "client_id")
    private Integer clientId;
    @Column(name = "reg_date")
    private LocalDateTime registrationDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "interaction_type")
    private InteractionType interactionType;


}
