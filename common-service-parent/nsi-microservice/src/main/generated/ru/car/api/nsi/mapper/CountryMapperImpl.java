package ru.car.api.nsi.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.car.api.nsi.entity.CountryEntity;
import ru.car.dto.nsi.CountryDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-06T19:08:19+0400",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.9 (Microsoft)"
)
@Component
public class CountryMapperImpl implements CountryMapper {

    @Override
    public CountryDto toDto(CountryEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CountryDto countryDto = new CountryDto();

        countryDto.setId( entity.getId() );
        countryDto.setDateWrite( entity.getDateWrite() );
        countryDto.setDateUpdate( entity.getDateUpdate() );
        countryDto.setName( entity.getName() );
        countryDto.setCode( entity.getCode() );
        countryDto.setShortName( entity.getShortName() );

        return countryDto;
    }

    @Override
    public CountryEntity toEntity(CountryDto dto) {
        if ( dto == null ) {
            return null;
        }

        CountryEntity countryEntity = new CountryEntity();

        countryEntity.setId( dto.getId() );
        countryEntity.setDateWrite( dto.getDateWrite() );
        countryEntity.setDateUpdate( dto.getDateUpdate() );
        countryEntity.setName( dto.getName() );
        countryEntity.setCode( dto.getCode() );
        countryEntity.setShortName( dto.getShortName() );

        return countryEntity;
    }

    @Override
    public List<CountryDto> toDtoList(List<CountryEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CountryDto> list = new ArrayList<CountryDto>( entities.size() );
        for ( CountryEntity countryEntity : entities ) {
            list.add( toDto( countryEntity ) );
        }

        return list;
    }

    @Override
    public List<CountryEntity> toEntityList(List<CountryDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<CountryEntity> list = new ArrayList<CountryEntity>( dtos.size() );
        for ( CountryDto countryDto : dtos ) {
            list.add( toEntity( countryDto ) );
        }

        return list;
    }
}
