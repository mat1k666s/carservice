package ru.car.api.nsi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "parts", schema = "nsi")
public class PartsEntity extends BaseEntity implements Serializable {
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "manufacturer")
    private String manufacturer;
}
