package ru.car.api.nsi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ru.car.api.nsi.entity.ServiceEntity;
import ru.car.dto.nsi.ServiceDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServiceMapper {
    ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);

    ServiceDto toDto(ServiceEntity entity);

    ServiceEntity toEntity(ServiceDto dto);

    List<ServiceDto> toDtoList(List<ServiceEntity> entities);

    List<ServiceEntity> toEntityList(List<ServiceDto> dtos);
}
