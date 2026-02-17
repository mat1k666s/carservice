package ru.car.api.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.car.api.client.InteractionType;
import ru.car.api.client.entity.ClientHistoryEntity;


import java.time.LocalDateTime;
import java.util.List;

public interface ClientHistoryRepository extends JpaRepository<ClientHistoryEntity, Integer>, JpaSpecificationExecutor<ClientHistoryEntity> {

    List<ClientHistoryEntity> findByRegistrationDateBetween(LocalDateTime start, LocalDateTime end);
    List<ClientHistoryEntity> findByClientId(Integer clientId);
    List<ClientHistoryEntity> findByInteractionType(InteractionType interactionType);


}
