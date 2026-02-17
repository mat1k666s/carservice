package ru.car.api.nsi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.car.api.nsi.entity.CountryEntity;
import ru.car.api.nsi.filtr.country.CountryFilter;
import ru.car.api.nsi.filtr.country.CountrySpecification;
import ru.car.api.nsi.mapper.CountryMapper;
import ru.car.api.nsi.repository.CountryRepository;
import ru.car.dto.nsi.CountryDto;

import java.util.List;
import java.util.Optional;

@Repository
@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;

    @Transactional
    public Page<CountryDto> getOrderPage(Pageable pageable, CountryFilter countryFilter){
        Specification<CountryEntity> specification = CountrySpecification.buildSpecification(countryFilter);
        Page<CountryEntity>entities = countryRepository.findAll(specification,pageable);
        Page<CountryDto>dtos = entities.map(v -> CountryMapper.INSTANCE.toDto(v));
        return dtos;
    }


    @Transactional
    public CountryDto getById(Integer id) {
        Optional<CountryEntity> entity = countryRepository.findById(id);
        if (entity.isPresent()) {
            return CountryMapper.INSTANCE.toDto(entity.get());
        }
        return null;

    }

    @Transactional
    public CountryDto add(CountryDto countryDto) {
        countryDto.setId(null);
        CountryEntity entity = CountryMapper.INSTANCE.toEntity(countryDto);
        entity = countryRepository.saveAndFlush(entity);
        return CountryMapper.INSTANCE.toDto(entity);

    }

    @Transactional
    public CountryDto update(CountryDto countryDto) {
        CountryEntity entity = CountryMapper.INSTANCE.toEntity(countryDto);
        entity = countryRepository.saveAndFlush(entity);
        return CountryMapper.INSTANCE.toDto(entity);
    }

    @Transactional
    public Integer deleteById(Integer id) {
        countryRepository.deleteById(id);
        return id;
    }
    @Transactional
    public List<CountryDto> findLikeShortName(String shortName){
        List<CountryEntity>entities = countryRepository.findByShortNameContainingIgnoreCase(shortName);
        return CountryMapper.INSTANCE.toDtoList(entities);
    }


}
