package ru.car.api.nsi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.car.api.nsi.entity.StampAutoEntity;
import ru.car.api.nsi.mapper.StampAutoMapper;
import ru.car.api.nsi.repository.StampAutoRepository;
import ru.car.dto.nsi.StampAutoDto;

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


}
