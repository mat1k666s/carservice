package ru.car.api.nsi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.car.api.nsi.dto.ServiceDto;
import ru.car.api.nsi.dto.StampAutoDto;
import ru.car.api.nsi.entity.ServiceEntity;
import ru.car.api.nsi.entity.StampAutoEntity;
import ru.car.api.nsi.mapper.ServiceMapper;
import ru.car.api.nsi.mapper.StampAutoMapper;
import ru.car.api.nsi.repository.ServiceRepository;

import java.util.Optional;

@Repository
@Service
@RequiredArgsConstructor
public class ServiceService {
    private ServiceRepository serviceRepository;

    @Transactional
    public ServiceDto getById(Integer id) {
        Optional<ServiceEntity> entity = serviceRepository.findById(id);
        if (entity.isPresent()) {
            return ServiceMapper.INSTANCE.toDto(entity.get());
        }
        return null;
    }

    @Transactional
    public ServiceDto add(ServiceDto serviceDto) {
        serviceDto.setId(null);
        ServiceEntity entity = ServiceMapper.INSTANCE.toEntity(serviceDto);
        entity = serviceRepository.saveAndFlush(entity);
        return ServiceMapper.INSTANCE.toDto(entity);

    }

    @Transactional
    public ServiceDto update(ServiceDto serviceDto) {
        ServiceEntity entity = ServiceMapper.INSTANCE.toEntity(serviceDto);
        entity = serviceRepository.saveAndFlush(entity);
        return ServiceMapper.INSTANCE.toDto(entity);

    }

    @Transactional
    public Integer deleteById(Integer id) {
        serviceRepository.deleteById(id);
        return id;
    }

}
