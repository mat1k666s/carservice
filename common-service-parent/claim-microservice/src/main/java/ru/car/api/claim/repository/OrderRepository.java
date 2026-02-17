package ru.car.api.claim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.car.api.claim.entity.OrderEntity;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer>, JpaSpecificationExecutor<OrderEntity> {
    List<OrderEntity> findByFullNameContainingIgnoreCase(String fullName);


    @Query("SELECT oe FROM OrderEntity oe WHERE oe.fullName like %:fullName%")
    List<OrderEntity> findLikeFullName(@Param("fullName") String fullName);

    @Modifying
    @Query(value = "update #{#entityName} t set t.address = :address WHERE t.phone = :phone")
    List<OrderEntity> setAddress(@Param("address") String address, @Param("phone") String phone);




}
