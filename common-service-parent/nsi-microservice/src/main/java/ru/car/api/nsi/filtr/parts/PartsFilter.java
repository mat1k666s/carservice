package ru.car.api.nsi.filtr.parts;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class PartsFilter {
    private String manufacturer;
    private BigDecimal price;

}
