package ru.car.dto.nsi;

import lombok.Data;

import java.util.Date;

@Data
public class CountryDto extends BaseDto {
    private Integer code;
    private String shortName;

}
