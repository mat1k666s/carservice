package ru.car.api.nsi.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.car.api.nsi.entity.PartsEntity;
import ru.car.dto.nsi.PartsDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-06T19:08:19+0400",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.9 (Microsoft)"
)
@Component
public class PartsMapperImpl implements PartsMapper {

    @Override
    public PartsDto toDto(PartsEntity entity) {
        if ( entity == null ) {
            return null;
        }

        PartsDto partsDto = new PartsDto();

        partsDto.setId( entity.getId() );
        partsDto.setDateWrite( entity.getDateWrite() );
        partsDto.setDateUpdate( entity.getDateUpdate() );
        partsDto.setName( entity.getName() );
        partsDto.setPrice( entity.getPrice() );
        partsDto.setManufacturer( entity.getManufacturer() );

        return partsDto;
    }

    @Override
    public PartsEntity toEntity(PartsDto dto) {
        if ( dto == null ) {
            return null;
        }

        PartsEntity partsEntity = new PartsEntity();

        partsEntity.setId( dto.getId() );
        partsEntity.setDateWrite( dto.getDateWrite() );
        partsEntity.setDateUpdate( dto.getDateUpdate() );
        partsEntity.setName( dto.getName() );
        partsEntity.setPrice( dto.getPrice() );
        partsEntity.setManufacturer( dto.getManufacturer() );

        return partsEntity;
    }

    @Override
    public List<PartsDto> toDtoList(List<PartsEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<PartsDto> list = new ArrayList<PartsDto>( entities.size() );
        for ( PartsEntity partsEntity : entities ) {
            list.add( toDto( partsEntity ) );
        }

        return list;
    }

    @Override
    public List<PartsEntity> toEntityList(List<PartsDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<PartsEntity> list = new ArrayList<PartsEntity>( dtos.size() );
        for ( PartsDto partsDto : dtos ) {
            list.add( toEntity( partsDto ) );
        }

        return list;
    }
}
