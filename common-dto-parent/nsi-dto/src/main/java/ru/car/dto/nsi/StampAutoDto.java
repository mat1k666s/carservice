package ru.car.dto.nsi;

import lombok.Data;


@Data
public class StampAutoDto extends BaseDto {
    private CountryDto country;
    private String shortName;



}
