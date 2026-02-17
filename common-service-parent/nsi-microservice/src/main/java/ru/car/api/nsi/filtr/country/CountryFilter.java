package ru.car.api.nsi.filtr.country;

import lombok.Data;

@Data
public class CountryFilter {
    private String shortName;
    private Integer code;
}
