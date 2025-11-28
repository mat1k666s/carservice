package ru.car.api.nsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.car.api.nsi.entity.CountryEntity;

public interface CountryRepository extends JpaRepository <CountryEntity,Integer>, JpaSpecificationExecutor<CountryEntity> {

}
