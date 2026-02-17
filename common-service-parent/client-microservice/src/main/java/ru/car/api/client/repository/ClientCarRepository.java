package ru.car.api.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.car.api.client.entity.ClientCarEntity;

import java.util.List;

public interface ClientCarRepository extends JpaRepository<ClientCarEntity, Integer>, JpaSpecificationExecutor<ClientCarEntity> {
    List<ClientCarEntity> findByColorContainingIgnoreCase(String color);

//    List<ClientCarEntity> findByMileageGreaterThan(Integer mileage);
//    List<ClientCarEntity> findByBrand(String brand);
//    List<ClientCarEntity> findByModel(String model);


    @Query("SELECT oe FROM ClientCarEntity oe WHERE oe.vin like %:vin%")
    List<ClientCarEntity> findLikeVin(@Param("vin") String vin);

    @Modifying
    @Query(value = "update #{#entityName} t set t.licensePlate = :licensePlate WHERE t.mileage = :mileage")
    List<ClientCarEntity> setLicensePlate(@Param("licensePlate") String licensePlate, @Param("mileage") Integer mileage);





}
