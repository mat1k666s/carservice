package ru.car.api.nsi.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.car.api.nsi.entity.ServiceEntity;
import ru.car.dto.nsi.ServiceDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-06T19:08:19+0400",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.9 (Microsoft)"
)
@Component
public class ServiceMapperImpl implements ServiceMapper {

    @Override
    public ServiceDto toDto(ServiceEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ServiceDto serviceDto = new ServiceDto();

        serviceDto.setId( entity.getId() );
        serviceDto.setDateWrite( entity.getDateWrite() );
        serviceDto.setDateUpdate( entity.getDateUpdate() );
        serviceDto.setName( entity.getName() );
        serviceDto.setShortName( entity.getShortName() );

        return serviceDto;
    }

    @Override
    public ServiceEntity toEntity(ServiceDto dto) {
        if ( dto == null ) {
            return null;
        }

        ServiceEntity serviceEntity = new ServiceEntity();

        serviceEntity.setId( dto.getId() );
        serviceEntity.setDateWrite( dto.getDateWrite() );
        serviceEntity.setDateUpdate( dto.getDateUpdate() );
        serviceEntity.setName( dto.getName() );
        serviceEntity.setShortName( dto.getShortName() );

        return serviceEntity;
    }

    @Override
    public List<ServiceDto> toDtoList(List<ServiceEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ServiceDto> list = new ArrayList<ServiceDto>( entities.size() );
        for ( ServiceEntity serviceEntity : entities ) {
            list.add( toDto( serviceEntity ) );
        }

        return list;
    }

    @Override
    public List<ServiceEntity> toEntityList(List<ServiceDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<ServiceEntity> list = new ArrayList<ServiceEntity>( dtos.size() );
        for ( ServiceDto serviceDto : dtos ) {
            list.add( toEntity( serviceDto ) );
        }

        return list;
    }
}
