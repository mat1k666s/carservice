package ru.car.api.nsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.car.api.nsi.entity.CountryEntity;
import ru.car.api.nsi.entity.ServiceEntity;

import java.util.List;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Integer>, JpaSpecificationExecutor<ServiceEntity> {
    List<ServiceEntity> findByShortNameContainingIgnoreCase(String shortName);

    @Query("SELECT сe FROM ServiceEntity  сe WHERE сe.shortName like %:shortName%")
    List<ServiceEntity> findLikeShortName(@Param("shortName") String shortName);

    List<ServiceEntity> findAllByShortNameIsNull();

    List<ServiceEntity> findAllByShortNameIsNotNull();
}
