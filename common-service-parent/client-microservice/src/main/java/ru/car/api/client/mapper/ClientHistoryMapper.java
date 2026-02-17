package ru.car.api.client.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.car.api.client.dto.ClientCarDto;
import ru.car.api.client.dto.ClientDto;
import ru.car.api.client.dto.ClientHistoryDto;
import ru.car.api.client.entity.ClientCarEntity;
import ru.car.api.client.entity.ClientEntity;
import ru.car.api.client.entity.ClientHistoryEntity;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ClientHistoryMapper {
    ClientHistoryMapper INSTANCE = Mappers.getMapper(ClientHistoryMapper.class);

    ClientHistoryDto toDto(ClientHistoryEntity entity);

    ClientHistoryEntity toEntity(ClientHistoryDto dto);

    List<ClientHistoryDto> toDtoList(List<ClientHistoryEntity> entities);

    List<ClientHistoryEntity> toEntityList(List<ClientHistoryDto> dtos);


}
