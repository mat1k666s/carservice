package ru.car.api.nsi.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class PartsDto extends BaseDto{
    private BigDecimal price;
    private String manufacturer;

}
