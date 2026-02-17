package ru.car.api.nsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.car.api.nsi.entity.CountryEntity;
import ru.car.api.nsi.entity.PartsEntity;
import ru.car.api.nsi.entity.ServiceEntity;

import java.math.BigDecimal;
import java.util.List;

public interface PartsRepository extends JpaRepository<PartsEntity, Integer>, JpaSpecificationExecutor<PartsEntity> {
    List<PartsEntity> findByPriceBetween(BigDecimal priceMin , BigDecimal priceMax);

    @Query("SELECT pe FROM PartsEntity pe WHERE pe.price = :price")
    List<PartsEntity> findLikePrice(@Param("price") BigDecimal price);

    @Modifying
    @Query(value = "update #{#entityName} t set t.price  = :price WHERE t.manufacturer = :manufacturer")
    void setManufacturerByPrice(@Param("price") BigDecimal price, @Param("manufacturer") String manufacturer);

    List<PartsEntity> findAllByPriceIsNull();

    List<PartsEntity> findAllByPriceIsNotNull();

}
