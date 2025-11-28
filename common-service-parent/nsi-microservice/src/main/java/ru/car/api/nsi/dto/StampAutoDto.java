package ru.car.api.nsi.dto;

import lombok.Data;

import java.util.Date;

@Data
public class StampAutoDto extends BaseDto {
    private CountryDto country;
    private String shortName;


}
