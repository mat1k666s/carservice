package ru.car.api.employee.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.car.api.employee.entity.EmployeeSkillEntity;
import ru.car.employee.dto.EmployeeSkillDto;

import java.util.List;
@Mapper(componentModel = "spring")
public interface EmployeeSkillMapper {
    EmployeeSkillDto toDto(EmployeeSkillEntity entity);

    EmployeeSkillEntity toEntity(EmployeeSkillDto dto);

    EmployeeSkillMapper INSTANCE = Mappers.getMapper(EmployeeSkillMapper.class);


    List<EmployeeSkillDto> toDtoList(List<EmployeeSkillEntity > entities);

    List<EmployeeSkillEntity> toEntityList(List<EmployeeSkillDto > dtos);

}
