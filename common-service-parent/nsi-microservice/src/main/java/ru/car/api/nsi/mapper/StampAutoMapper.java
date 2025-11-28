package ru.car.api.nsi.mapper;

import org.mapstruct.factory.Mappers;
import ru.car.api.nsi.dto.StampAutoDto;
import ru.car.api.nsi.entity.StampAutoEntity;

import java.util.List;

public interface StampAutoMapper {
    StampAutoMapper INSTANCE = Mappers.getMapper(StampAutoMapper.class);

    StampAutoDto toDto(StampAutoEntity entity);

    StampAutoEntity toEntity(StampAutoDto dto);

    List<StampAutoDto> toDtoList(List<StampAutoEntity> entities);

    List<StampAutoEntity> toEntityList(List<StampAutoDto> dtos);
}
