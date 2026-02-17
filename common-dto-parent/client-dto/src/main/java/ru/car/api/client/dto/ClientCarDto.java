package ru.car.api.client.dto;

import lombok.Data;



@Data
public class ClientCarDto {
   private Integer id;
   private Integer stampId;
   private String vin;
   private String licensePlate;
   private Integer manufactureYear;
   private Integer mileage;
   private String color;
   private String brand;
   private String model;
   private Integer clientId;
   private String clientName;




}
