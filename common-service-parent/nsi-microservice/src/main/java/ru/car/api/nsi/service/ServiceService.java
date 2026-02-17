package ru.car.api.nsi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.car.api.nsi.entity.ServiceEntity;
import ru.car.api.nsi.filtr.service.ServiceFilter;
import ru.car.api.nsi.filtr.service.ServiceSpecification;
import ru.car.api.nsi.mapper.ServiceMapper;
import ru.car.api.nsi.repository.ServiceRepository;
import ru.car.dto.nsi.ServiceDto;

import java.util.List;
import java.util.Optional;

@Repository
@Service
@RequiredArgsConstructor
public class ServiceService {
    private final ServiceRepository serviceRepository;

    @Transactional
    public Page<ServiceDto> getServicePage(Pageable pageable, ServiceFilter serviceFilter){
        Specification<ServiceEntity> specification = ServiceSpecification.buildSpecification(serviceFilter);
        Page<ServiceEntity>entities = serviceRepository.findAll(specification,pageable);
        Page<ServiceDto>dtos = entities.map(s -> ServiceMapper.INSTANCE.toDto(s));
        return dtos;

    }

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
    @Transactional
    public List<ServiceDto> findLikeShortName(String shortName){
        List<ServiceEntity>entities = serviceRepository.findByShortNameContainingIgnoreCase(shortName);
        return ServiceMapper.INSTANCE.toDtoList(entities);
    }

}
