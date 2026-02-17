package ru.car.api.nsi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.car.api.nsi.entity.StampAutoEntity;
import ru.car.api.nsi.filtr.stampAuto.StampAutoFilter;
import ru.car.api.nsi.filtr.stampAuto.StampAutoSpecification;
import ru.car.api.nsi.mapper.StampAutoMapper;
import ru.car.api.nsi.repository.StampAutoRepository;
import ru.car.dto.nsi.StampAutoDto;

import java.util.List;
import java.util.Optional;

@Repository
@Service
@RequiredArgsConstructor
public class StampAutoService {

    private final StampAutoRepository stampAutoRepository;

    @Transactional
    public StampAutoDto getById(Integer id) {
        Optional<StampAutoEntity> entity = stampAutoRepository.findById(id);
        if (entity.isPresent()) {
            return StampAutoMapper.INSTANCE.toDto(entity.get());
        }
        return null;
    }

    @Transactional
    public StampAutoDto add(StampAutoDto stampAutoDto) {
        stampAutoDto.setId(null);
        StampAutoEntity entity = StampAutoMapper.INSTANCE.toEntity(stampAutoDto);
        entity = stampAutoRepository.saveAndFlush(entity);
        return StampAutoMapper.INSTANCE.toDto(entity);

    }

    @Transactional
    public StampAutoDto update(StampAutoDto stampAutoDto) {
        StampAutoEntity entity = StampAutoMapper.INSTANCE.toEntity(stampAutoDto);
        entity = stampAutoRepository.saveAndFlush(entity);
        return StampAutoMapper.INSTANCE.toDto(entity);

    }

    @Transactional
    public Integer deleteById(Integer id) {
        stampAutoRepository.deleteById(id);
        return id;
    }
    @Transactional
    public List<StampAutoDto> findLikeCountryName(String countryName){
        List<StampAutoEntity>entities = stampAutoRepository.findLikeCountryName(countryName);
        return StampAutoMapper.INSTANCE.toDtoList(entities);
    }
    @Transactional
    public List<StampAutoDto> setCountryById(String country, Integer id){
        List<StampAutoEntity>entities = stampAutoRepository.setCountryById(country, id);
        return StampAutoMapper.INSTANCE.toDtoList(entities);
    }
    @Transactional
    public Page<StampAutoDto> getStampAutoPage(StampAutoFilter filter, Pageable pageable) {
        Specification<StampAutoEntity>specification = StampAutoSpecification.buildSpecification(filter);
        Page<StampAutoEntity> entities = stampAutoRepository.findAll(specification, pageable);
        Page<StampAutoDto>dtos = entities.map(s -> StampAutoMapper.INSTANCE.toDto(s));
        return dtos;
    }




}
