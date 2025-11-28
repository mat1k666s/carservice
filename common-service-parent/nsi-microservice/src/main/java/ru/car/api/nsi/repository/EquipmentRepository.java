package ru.car.api.nsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.car.api.nsi.entity.EquipmentEntity;

public interface EquipmentRepository extends JpaRepository<EquipmentEntity,Integer>, JpaSpecificationExecutor<EquipmentEntity> {
}
