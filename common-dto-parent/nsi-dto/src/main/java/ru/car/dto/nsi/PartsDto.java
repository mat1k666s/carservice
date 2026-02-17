package ru.car.dto.nsi;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PartsDto extends BaseDto{
    private BigDecimal price;
    private String manufacturer;

}
