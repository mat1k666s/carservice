package ru.car.dto.nsi;

import lombok.Data;



@Data
public class CountryDto extends BaseDto {
    private Integer code;
    private String shortName;

}
