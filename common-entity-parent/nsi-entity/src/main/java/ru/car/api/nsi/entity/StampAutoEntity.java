package ru.car.api.nsi.entity;

import jakarta.persistence.*;
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
@Table(name = "stamp_auto", schema = "nsi")
public class StampAutoEntity extends BaseEntity implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_country", referencedColumnName = "id")
    private CountryEntity country;
    @Column(name = "short_Name")
    private String shortName;



}
