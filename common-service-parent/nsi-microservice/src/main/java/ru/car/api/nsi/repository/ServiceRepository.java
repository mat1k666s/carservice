package ru.car.api.nsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.car.api.nsi.entity.ServiceEntity;

public interface ServiceRepository extends JpaRepository<ServiceEntity,Integer>, JpaSpecificationExecutor<ServiceEntity> {
}
