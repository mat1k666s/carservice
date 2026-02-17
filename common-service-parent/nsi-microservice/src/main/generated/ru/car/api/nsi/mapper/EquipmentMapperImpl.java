package ru.car.api.nsi.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.car.api.nsi.entity.EquipmentEntity;
import ru.car.dto.nsi.EquipmentDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-06T19:08:19+0400",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.9 (Microsoft)"
)
@Component
public class EquipmentMapperImpl implements EquipmentMapper {

    @Override
    public EquipmentDto toDto(EquipmentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        EquipmentDto equipmentDto = new EquipmentDto();

        equipmentDto.setId( entity.getId() );
        equipmentDto.setDateWrite( entity.getDateWrite() );
        equipmentDto.setDateUpdate( entity.getDateUpdate() );
        equipmentDto.setName( entity.getName() );
        equipmentDto.setCode( entity.getCode() );

        return equipmentDto;
    }

    @Override
    public EquipmentEntity toEntity(EquipmentDto dto) {
        if ( dto == null ) {
            return null;
        }

        EquipmentEntity equipmentEntity = new EquipmentEntity();

        equipmentEntity.setId( dto.getId() );
        equipmentEntity.setDateWrite( dto.getDateWrite() );
        equipmentEntity.setDateUpdate( dto.getDateUpdate() );
        equipmentEntity.setName( dto.getName() );
        equipmentEntity.setCode( dto.getCode() );

        return equipmentEntity;
    }

    @Override
    public List<EquipmentDto> toDtoList(List<EquipmentEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<EquipmentDto> list = new ArrayList<EquipmentDto>( entities.size() );
        for ( EquipmentEntity equipmentEntity : entities ) {
            list.add( toDto( equipmentEntity ) );
        }

        return list;
    }

    @Override
    public List<EquipmentEntity> toEntityList(List<EquipmentDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<EquipmentEntity> list = new ArrayList<EquipmentEntity>( dtos.size() );
        for ( EquipmentDto equipmentDto : dtos ) {
            list.add( toEntity( equipmentDto ) );
        }

        return list;
    }
}
