package ru.car.api.client.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.car.api.client.InteractionType;
import ru.car.api.client.dto.ClientHistoryDto;
import ru.car.api.client.entity.ClientHistoryEntity;

import ru.car.api.client.mapper.ClientHistoryMapper;
import ru.car.api.client.repository.ClientHistoryRepository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientHistoryService {
    private final ClientHistoryRepository clientHistoryRepository;

    @Transactional
    public ClientHistoryDto getById(Integer id) {
        Optional<ClientHistoryEntity> entity = clientHistoryRepository.findById(id);
        if (entity.isPresent()) {
            return ClientHistoryMapper.INSTANCE.toDto(entity.get());
        }
        return null;
    }

    @Transactional
    public ClientHistoryDto add(ClientHistoryDto ClientHistoryDto) {
        ClientHistoryDto.setId(null);
        ClientHistoryEntity entity = ClientHistoryMapper.INSTANCE.toEntity(ClientHistoryDto);
        entity = clientHistoryRepository.saveAndFlush(entity);
        return ClientHistoryMapper.INSTANCE.toDto(entity);

    }

    @Transactional
    public ClientHistoryDto update(ClientHistoryDto ClientHistoryDto) {
        ClientHistoryEntity entity = ClientHistoryMapper.INSTANCE.toEntity(ClientHistoryDto);
        entity = clientHistoryRepository.saveAndFlush(entity);
        return ClientHistoryMapper.INSTANCE.toDto(entity);
    }

    @Transactional
    public Integer deleteById(Integer id) {
        clientHistoryRepository.deleteById(id);
        return id;
    }
    @Transactional
    public List<ClientHistoryDto> findByRegistrationDateBetween(LocalDateTime start, LocalDateTime end) {
        List<ClientHistoryEntity> entities = clientHistoryRepository.findByRegistrationDateBetween(start, end);
        return ClientHistoryMapper.INSTANCE.toDtoList(entities);
    }
    @Transactional
    public List<ClientHistoryDto> findByInteractionType(InteractionType interactionType) {
        List<ClientHistoryEntity> entities = clientHistoryRepository.findByInteractionType(interactionType);
        return ClientHistoryMapper.INSTANCE.toDtoList(entities);
    }
    @Transactional
    public List<ClientHistoryDto> findByClientId(Integer clientId) {
        List<ClientHistoryEntity> entities = clientHistoryRepository.findByClientId(clientId);
        return ClientHistoryMapper.INSTANCE.toDtoList(entities);
    }
}
