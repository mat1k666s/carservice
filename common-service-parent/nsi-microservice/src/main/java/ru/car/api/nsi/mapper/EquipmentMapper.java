package ru.car.api.nsi.mapper;

import org.mapstruct.factory.Mappers;
import ru.car.api.nsi.dto.EquipmentDto;
import ru.car.api.nsi.entity.EquipmentEntity;

import java.util.List;

public interface EquipmentMapper {
    EquipmentMapper INSTANCE = Mappers.getMapper(EquipmentMapper.class);

    EquipmentDto toDto(EquipmentEntity entity);

    EquipmentEntity toEntity(EquipmentDto dto);

    List<EquipmentDto> toDtoList(List<EquipmentEntity> entities);

    List<EquipmentEntity> toEntityList(List<EquipmentDto> dtos);
}
