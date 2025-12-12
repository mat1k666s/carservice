package ru.car.api.claim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.car.api.claim.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity,Integer>, JpaSpecificationExecutor<OrderEntity> {

}
