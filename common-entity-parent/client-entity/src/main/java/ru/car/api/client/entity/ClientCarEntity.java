package ru.car.api.client.entity;

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
@Table(name = "client_car", schema = "client")
public class ClientCarEntity implements Serializable {
    @Id
    @Column(name = "id", updatable = false , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "stamp_id")
    private Integer stampId;
    @Column(name = "vin")
    private String vin;
    @Column(name = "license_plate")
    private String licensePlate;
    @Column(name = "manufacture_year")
    private Integer manufactureYear;
    @Column(name = "mileage")
    private Integer mileage;
    @Column(name = "color")
    private String color;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    







}
