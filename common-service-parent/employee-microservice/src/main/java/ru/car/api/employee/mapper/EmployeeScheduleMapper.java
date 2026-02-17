package ru.car.api.employee.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.car.api.employee.entity.EmployeeScheduleEntity;
import ru.car.employee.dto.EmployeeScheduleDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeScheduleMapper {
    EmployeeScheduleDto toDto(EmployeeScheduleEntity entity);

    EmployeeScheduleEntity toEntity(EmployeeScheduleDto dto);

    EmployeeScheduleMapper INSTANCE = Mappers.getMapper(EmployeeScheduleMapper.class);


    List<EmployeeScheduleDto> toDtoList(List<EmployeeScheduleEntity > entities);

    List<EmployeeScheduleEntity> toEntityList(List<EmployeeScheduleDto > dtos);
}
