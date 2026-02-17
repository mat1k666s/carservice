package ru.car.api.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.car.api.client.ClientStatus;
import ru.car.api.client.entity.ClientEntity;


import java.time.LocalDateTime;
import java.util.List;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> , JpaSpecificationExecutor<ClientEntity> {
    List<ClientEntity> findByLastNameContainingIgnoreCase(String lastName);
    List<ClientEntity> findByFirstNameContainingIgnoreCase(String firstName);
    List<ClientEntity> findByMiddleNameContainingIgnoreCase(String middleName);
    List<ClientEntity> findByLastNameAndFirstName(String lastName, String firstName);

    List<ClientEntity> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);


    @Query("SELECT c FROM ClientEntity c WHERE c.status = :status")
    List<ClientEntity> countByStatus(@Param("status") ClientStatus status);



    @Query("SELECT oe FROM ClientEntity oe WHERE oe.phone like %:phone%")
    List<ClientEntity> findLikePhone(@Param("phone") String phone);

    @Modifying
    @Query(value = "update #{#entityName} a set a.address = :address WHERE a.email = :email")
    List<ClientEntity> setAddress(@Param("address") String address, @Param("email") String email);
}
