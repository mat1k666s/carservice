package ru.car.api.nsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.car.api.nsi.entity.StampAutoEntity;

public interface StampAutoRepository extends JpaRepository<StampAutoEntity,Integer>, JpaSpecificationExecutor<StampAutoEntity> {
}
