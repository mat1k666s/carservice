package ru.car.api.claim.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.car.api.claim.entity.OrderEntity;
import ru.car.dto.claim.OrderDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDto toDto(OrderEntity entity);

    OrderEntity toEntity(OrderDto dto);

    List<OrderDto> toDtoList(List<OrderEntity> entities);

    List<OrderEntity> toEntityList(List<OrderDto> dtos);




}
