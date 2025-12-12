package ru.car.api.claim.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.car.api.claim.dto.OrderDto;
import ru.car.api.claim.entity.OrderEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDto toDto(OrderEntity entity);

    OrderEntity toEntity(OrderDto dto);




}
