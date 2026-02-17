package ru.car.api.client.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.car.api.client.dto.ClientDto;
import ru.car.api.client.entity.ClientEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDto toDto(ClientEntity entity);

    ClientEntity toEntity(ClientDto dto);

    List<ClientDto> toDtoList(List<ClientEntity> entities);

    List<ClientEntity> toEntityList(List<ClientDto> dtos);
}
