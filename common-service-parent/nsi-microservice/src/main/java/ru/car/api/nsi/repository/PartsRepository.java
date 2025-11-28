package ru.car.api.nsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.car.api.nsi.entity.PartsEntity;

public interface PartsRepository extends JpaRepository<PartsEntity,Integer>, JpaSpecificationExecutor<PartsEntity> {
}
