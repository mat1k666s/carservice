package ru.car.api.nsi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.car.api.nsi.dto.PartsDto;
import ru.car.api.nsi.dto.PartsDto;
import ru.car.api.nsi.entity.PartsEntity;
import ru.car.api.nsi.entity.PartsEntity;
import ru.car.api.nsi.mapper.PartsMapper;
import ru.car.api.nsi.mapper.PartsMapper;
import ru.car.api.nsi.repository.PartsRepository;

import java.util.Optional;

@Repository
@Service
@RequiredArgsConstructor
public class PartsService {
    private final PartsRepository partsRepository;

    @Transactional
    public PartsDto getById(Integer id) {
        Optional<PartsEntity> entity = partsRepository.findById(id);
        if (entity.isPresent()) {
            return PartsMapper.INSTANCE.toDto(entity.get());
        }
        return null;
    }

    @Transactional
    public PartsDto add(PartsDto partsDto) {
        partsDto.setId(null);
        PartsEntity entity = PartsMapper.INSTANCE.toEntity(partsDto);
        entity = partsRepository.saveAndFlush(entity);
        return PartsMapper.INSTANCE.toDto(entity);

    }

    @Transactional
    public PartsDto update(PartsDto partsDto) {
        PartsEntity entity = PartsMapper.INSTANCE.toEntity(partsDto);
        entity = partsRepository.saveAndFlush(entity);
        return PartsMapper.INSTANCE.toDto(entity);

    }

    @Transactional
    public Integer deleteById(Integer id) {
        partsRepository.deleteById(id);
        return id;
    }
}
