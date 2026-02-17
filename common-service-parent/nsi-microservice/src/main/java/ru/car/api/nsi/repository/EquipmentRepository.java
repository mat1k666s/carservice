package ru.car.api.nsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.car.api.nsi.entity.EquipmentEntity;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<EquipmentEntity, Integer>, JpaSpecificationExecutor<EquipmentEntity> {
    List<EquipmentEntity> findByCodeContainingIgnoreCase(String code);


    @Query("SELECT ee FROM EquipmentEntity ee WHERE ee.code like %:code%")
    List<EquipmentEntity> findLikeCode(@Param("code") String code);


    List<EquipmentEntity> findAllByCodeIsNull();

    List<EquipmentEntity> findAllByCodeIsNotNull();
}
