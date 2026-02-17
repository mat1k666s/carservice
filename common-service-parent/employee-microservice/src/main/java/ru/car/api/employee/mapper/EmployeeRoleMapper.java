package ru.car.api.employee.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.car.api.employee.entity.EmployeeRoleEntity;
import ru.car.employee.dto.EmployeeRoleDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeRoleMapper {
    EmployeeRoleDto toDto(EmployeeRoleEntity entity);

    EmployeeRoleEntity toEntity(EmployeeRoleDto dto);

    EmployeeRoleMapper INSTANCE = Mappers.getMapper(EmployeeRoleMapper.class);


    List<EmployeeRoleDto> toDtoList(List<EmployeeRoleEntity > entities);

    List<EmployeeRoleEntity> toEntityList(List<EmployeeRoleDto > dtos);
}
