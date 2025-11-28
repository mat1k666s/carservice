package ru.car.api.nsi.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BaseDto {
    private Integer id;
    private Date dateWrite;
    private Date dateUpdate;
    private String name;

}
