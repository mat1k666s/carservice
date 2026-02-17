package ru.car.api.nsi.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.car.api.nsi.entity.CountryEntity;
import ru.car.api.nsi.entity.StampAutoEntity;
import ru.car.dto.nsi.CountryDto;
import ru.car.dto.nsi.StampAutoDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-06T19:08:19+0400",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.9 (Microsoft)"
)
@Component
public class StampAutoMapperImpl implements StampAutoMapper {

    @Override
    public StampAutoDto toDto(StampAutoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        StampAutoDto stampAutoDto = new StampAutoDto();

        stampAutoDto.setId( entity.getId() );
        stampAutoDto.setDateWrite( entity.getDateWrite() );
        stampAutoDto.setDateUpdate( entity.getDateUpdate() );
        stampAutoDto.setName( entity.getName() );
        stampAutoDto.setCountry( countryEntityToCountryDto( entity.getCountry() ) );
        stampAutoDto.setShortName( entity.getShortName() );

        return stampAutoDto;
    }

    @Override
    public StampAutoEntity toEntity(StampAutoDto dto) {
        if ( dto == null ) {
            return null;
        }

        StampAutoEntity stampAutoEntity = new StampAutoEntity();

        stampAutoEntity.setId( dto.getId() );
        stampAutoEntity.setDateWrite( dto.getDateWrite() );
        stampAutoEntity.setDateUpdate( dto.getDateUpdate() );
        stampAutoEntity.setName( dto.getName() );
        stampAutoEntity.setCountry( countryDtoToCountryEntity( dto.getCountry() ) );
        stampAutoEntity.setShortName( dto.getShortName() );

        return stampAutoEntity;
    }

    @Override
    public List<StampAutoDto> toDtoList(List<StampAutoEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<StampAutoDto> list = new ArrayList<StampAutoDto>( entities.size() );
        for ( StampAutoEntity stampAutoEntity : entities ) {
            list.add( toDto( stampAutoEntity ) );
        }

        return list;
    }

    @Override
    public List<StampAutoEntity> toEntityList(List<StampAutoDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<StampAutoEntity> list = new ArrayList<StampAutoEntity>( dtos.size() );
        for ( StampAutoDto stampAutoDto : dtos ) {
            list.add( toEntity( stampAutoDto ) );
        }

        return list;
    }

    protected CountryDto countryEntityToCountryDto(CountryEntity countryEntity) {
        if ( countryEntity == null ) {
            return null;
        }

        CountryDto countryDto = new CountryDto();

        countryDto.setId( countryEntity.getId() );
        countryDto.setDateWrite( countryEntity.getDateWrite() );
        countryDto.setDateUpdate( countryEntity.getDateUpdate() );
        countryDto.setName( countryEntity.getName() );
        countryDto.setCode( countryEntity.getCode() );
        countryDto.setShortName( countryEntity.getShortName() );

        return countryDto;
    }

    protected CountryEntity countryDtoToCountryEntity(CountryDto countryDto) {
        if ( countryDto == null ) {
            return null;
        }

        CountryEntity countryEntity = new CountryEntity();

        countryEntity.setId( countryDto.getId() );
        countryEntity.setDateWrite( countryDto.getDateWrite() );
        countryEntity.setDateUpdate( countryDto.getDateUpdate() );
        countryEntity.setName( countryDto.getName() );
        countryEntity.setCode( countryDto.getCode() );
        countryEntity.setShortName( countryDto.getShortName() );

        return countryEntity;
    }
}
