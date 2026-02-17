package ru.car.api.nsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.car.api.nsi.entity.CountryEntity;

import java.util.List;

public interface CountryRepository extends JpaRepository<CountryEntity, Integer>, JpaSpecificationExecutor<CountryEntity> {
    List<CountryEntity> findByShortNameContainingIgnoreCase(String shortName);

    @Query("SELECT сe FROM CountryEntity  сe WHERE сe.shortName like %:shortName%")
    List<CountryEntity> findLikeShortName(@Param("shortName") String shortName);

    @Modifying
    @Query(value = "update #{#entityName} t set t.shortName = :shortName WHERE t.code = :code")
    void setShortName(@Param("shortName") String shortName, @Param("code") Integer code);


    List<CountryEntity> findAllByCodeIsNull();

    List<CountryEntity> findAllByCodeIsNotNull();

}
