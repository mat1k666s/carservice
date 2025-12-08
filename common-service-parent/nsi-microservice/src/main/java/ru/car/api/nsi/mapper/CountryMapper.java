package ru.car.api.nsi.mapper;

import org.mapstruct.factory.Mappers;
import ru.car.api.nsi.dto.CountryDto;
import ru.car.api.nsi.entity.CountryEntity;


import java.util.List;

public interface CountryMapper {

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    CountryDto toDto(CountryEntity entity);

    CountryEntity toEntity(CountryDto dto);

    List<CountryDto> toDtoList(List<CountryEntity> entities);

    List<CountryEntity> toEntityList(List<CountryDto> dtos);
}
