package ru.car.api.client.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.car.api.client.dto.ClientCarDto;
import ru.car.api.client.entity.ClientCarEntity;
import ru.car.api.client.mapper.ClientCarMapper;
import ru.car.api.client.repository.ClientCarRepository;

import java.util.List;
import java.util.Optional;


@Repository
@Service
@RequiredArgsConstructor
public class ClientCarService {
    private final ClientCarRepository clientCarRepository;

    @Transactional
    public ClientCarDto getById(Integer id) {
        Optional<ClientCarEntity> entity = clientCarRepository.findById(id);
        if (entity.isPresent()) {
            return ClientCarMapper.INSTANCE.toDto(entity.get());
        }
        return null;
    }
    @Transactional
    public ClientCarDto add(ClientCarDto clientCarDto) {
        clientCarDto.setId(null);
        ClientCarEntity entity = ClientCarMapper.INSTANCE.toEntity(clientCarDto);
        entity = clientCarRepository.saveAndFlush(entity);
        return ClientCarMapper.INSTANCE.toDto(entity);

    }

    @Transactional
    public ClientCarDto update(ClientCarDto clientCarDto) {
        ClientCarEntity entity = ClientCarMapper.INSTANCE.toEntity(clientCarDto);
        entity = clientCarRepository.saveAndFlush(entity);
        return ClientCarMapper.INSTANCE.toDto(entity);

    }

    @Transactional
    public Integer deleteById(Integer id) {
        clientCarRepository.deleteById(id);
        return id;
    }

    @Transactional
    public List<ClientCarDto> findByColorContainingIgnoreCase(String color) {
        List<ClientCarEntity>entities = clientCarRepository.findByColorContainingIgnoreCase(color);
        return ClientCarMapper.INSTANCE.toDtoList(entities);
    }
    @Transactional
    public List<ClientCarDto> findLikeVin(String vin) {
        List<ClientCarEntity>entities = clientCarRepository.findLikeVin(vin);
        return ClientCarMapper.INSTANCE.toDtoList(entities);
    }
    @Transactional
    public List<ClientCarDto> setLicensePlate(String licensePlate, Integer mileage) {
        List<ClientCarEntity>entities = clientCarRepository.setLicensePlate(licensePlate, mileage);
        return ClientCarMapper.INSTANCE.toDtoList(entities);
    }
}


