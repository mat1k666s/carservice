package ru.car.api.client.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.car.api.client.dto.ClientCarDto;
import ru.car.api.client.entity.ClientCarEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientCarMapper {
    ClientCarMapper INSTANCE = Mappers.getMapper(ClientCarMapper.class);

    ClientCarDto toDto(ClientCarEntity entity);

    ClientCarEntity toEntity(ClientCarDto dto);

    List<ClientCarDto> toDtoList(List<ClientCarEntity> entities);

    List<ClientCarEntity> toEntityList(List<ClientCarDto> dtos);
}
