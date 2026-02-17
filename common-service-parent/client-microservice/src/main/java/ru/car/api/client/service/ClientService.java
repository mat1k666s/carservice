package ru.car.api.client.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.car.api.client.ClientStatus;
import ru.car.api.client.dto.ClientDto;

import ru.car.api.client.entity.ClientEntity;

import ru.car.api.client.mapper.ClientMapper;
import ru.car.api.client.repository.ClientRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    @Transactional
    public ClientDto getById(Integer id) {
        Optional<ClientEntity> entity = clientRepository.findById(id);
        if (entity.isPresent()) {
            return ClientMapper.INSTANCE.toDto(entity.get());
        }
        return null;
    }

    @Transactional
    public ClientDto add(ClientDto ClientDto) {
        ClientDto.setId(null);
        ClientEntity entity = ClientMapper.INSTANCE.toEntity(ClientDto);
        entity = clientRepository.saveAndFlush(entity);
        return ClientMapper.INSTANCE.toDto(entity);

    }

    @Transactional
    public ClientDto update(ClientDto ClientDto) {
        ClientEntity entity = ClientMapper.INSTANCE.toEntity(ClientDto);
        entity = clientRepository.saveAndFlush(entity);
        return ClientMapper.INSTANCE.toDto(entity);
    }

    @Transactional
    public Integer deleteById(Integer id) {
        clientRepository.deleteById(id);
        return id;
    }
    @Transactional
    public List<ClientDto> findByLastNameContainingIgnoreCase(String lastName) {
        List<ClientEntity> entities = clientRepository.findByLastNameContainingIgnoreCase(lastName);
        return ClientMapper.INSTANCE.toDtoList(entities);
    }
    @Transactional
    public List<ClientDto> findByFirstNameContainingIgnoreCase(String firstName) {
        List<ClientEntity> entities = clientRepository.findByFirstNameContainingIgnoreCase(firstName);
        return ClientMapper.INSTANCE.toDtoList(entities);
    }
    @Transactional
    public List<ClientDto> findByMiddleNameContainingIgnoreCase(String middleName) {
        List<ClientEntity> entities = clientRepository.findByMiddleNameContainingIgnoreCase(middleName);
        return ClientMapper.INSTANCE.toDtoList(entities);
    }
    @Transactional
    public List<ClientDto> findLikePhone(String phone) {
        List<ClientEntity> entities = clientRepository.findLikePhone(phone);
        return ClientMapper.INSTANCE.toDtoList(entities);
    }
    @Transactional
    public List<ClientDto> setAddress(String address, String email) {
        List<ClientEntity> entities = clientRepository.setAddress(address, email);
        return ClientMapper.INSTANCE.toDtoList(entities);
    }
    @Transactional
    public List<ClientDto> findByLastNameAndFirstName(String lastName, String firstName) {
        List<ClientEntity> entities = clientRepository.findByLastNameAndFirstName(lastName, firstName);
        return ClientMapper.INSTANCE.toDtoList(entities);
    }
    @Transactional
    public List<ClientDto> countByStatus(ClientStatus status) {
        List<ClientEntity> entities = clientRepository.countByStatus(status);
        return ClientMapper.INSTANCE.toDtoList(entities);
    }
    @Transactional
    public List<ClientDto> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end) {
        List<ClientEntity> entities = clientRepository.findByCreatedAtBetween(start, end);
        return ClientMapper.INSTANCE.toDtoList(entities);
    }


}
    

  

