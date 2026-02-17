package ru.car.api.employee.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.car.api.employee.entity.EmployeeEntity;
import ru.car.employee.dto.EmployeeDto;


import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDto toDto(EmployeeEntity entity);

    EmployeeEntity toEntity(EmployeeDto dto);

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);


    List<EmployeeDto> toDtoList(List<EmployeeEntity > entities);

    List<EmployeeEntity> toEntityList(List<EmployeeDto > dtos);
}
