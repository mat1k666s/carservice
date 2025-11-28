package ru.car.api.nsi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "service", schema = "nsi")
public class ServiceEntity extends BaseEntity implements Serializable {
    @Column(name = "short_Name")
    private String shortName;
}
