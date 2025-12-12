package ru.car.api.nsi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ru.car.api.nsi.entity.PartsEntity;
import ru.car.dto.nsi.PartsDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PartsMapper {
    PartsMapper INSTANCE = Mappers.getMapper(PartsMapper.class);

    PartsDto toDto(PartsEntity entity);

    PartsEntity toEntity(PartsDto dto);

    List<PartsDto> toDtoList(List<PartsEntity> entities);

    List<PartsEntity> toEntityList(List<PartsDto> dtos);
}
