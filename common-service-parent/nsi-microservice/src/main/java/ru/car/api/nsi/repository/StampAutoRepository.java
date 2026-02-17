package ru.car.api.nsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.car.api.nsi.entity.StampAutoEntity;

import java.util.List;

public interface StampAutoRepository extends JpaRepository<StampAutoEntity, Integer>, JpaSpecificationExecutor<StampAutoEntity> {
    List<StampAutoEntity> findByCountryNameContainingIgnoreCase(String countryName);

    @Query("SELECT sae FROM StampAutoEntity sae WHERE sae.country.name like %:name%")
    List<StampAutoEntity> findLikeCountryName(@Param("name") String countryName);


    @Modifying
    @Query(value = "update #{#entityName} t set t.country  = :country WHERE t.id = :id")
    List<StampAutoEntity> setCountryById(@Param("country") String country, @Param("id") Integer id);


}
