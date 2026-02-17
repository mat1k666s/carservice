package ru.car.api.employee.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.car.api.employee.entity.EmployeeEntity;
import ru.car.api.employee.entity.EmployeeScheduleEntity;
import ru.car.api.employee.mapper.EmployeeScheduleMapper;
import ru.car.api.employee.repository.EmployeeScheduleRepository;
import ru.car.employee.dto.EmployeeScheduleDto;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeScheduleService {
    private final EmployeeScheduleRepository employeeScheduleRepository;

    @Transactional
    public EmployeeScheduleDto getById(Integer id) {
        Optional<EmployeeScheduleEntity> entity = employeeScheduleRepository.findById(id);
        if (entity.isPresent()) {
            return EmployeeScheduleMapper.INSTANCE.toDto(entity.get());
        }
        return null;
    }

    @Transactional
    public EmployeeScheduleDto add(EmployeeScheduleDto employeeScheduleDto) {
        employeeScheduleDto.setId(null);
        EmployeeScheduleEntity entity = EmployeeScheduleMapper.INSTANCE.toEntity(employeeScheduleDto);
        entity = employeeScheduleRepository.saveAndFlush(entity);
        return EmployeeScheduleMapper.INSTANCE.toDto(entity);

    }

    @Transactional
    public EmployeeScheduleDto update(EmployeeScheduleDto employeeScheduleDto) {
        EmployeeScheduleEntity entity = EmployeeScheduleMapper.INSTANCE.toEntity(employeeScheduleDto);
        entity = employeeScheduleRepository.saveAndFlush(entity);
        return EmployeeScheduleMapper.INSTANCE.toDto(entity);
    }

    @Transactional
    public Integer deleteById(Integer id) {
        employeeScheduleRepository.deleteById(id);
        return id;
    }
    @Transactional
    public List<EmployeeScheduleDto> findByEmployeeId(EmployeeEntity employeeId) {
        List<EmployeeScheduleEntity> entities= employeeScheduleRepository.findByEmployeeId(employeeId);
        return EmployeeScheduleMapper.INSTANCE.toDtoList(entities);
    }

}
