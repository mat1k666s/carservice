package ru.car.api.nsi.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CountryDto extends BaseDto {
    private Integer code;
    private String shortName;

}
