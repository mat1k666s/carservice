package ru.car.api.nsi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.car.api.nsi.dto.EquipmentDto;
import ru.car.api.nsi.dto.EquipmentDto;
import ru.car.api.nsi.entity.EquipmentEntity;
import ru.car.api.nsi.entity.EquipmentEntity;
import ru.car.api.nsi.mapper.EquipmentMapper;
import ru.car.api.nsi.mapper.EquipmentMapper;
import ru.car.api.nsi.repository.EquipmentRepository;

import java.util.Optional;

@Repository
@Service
@RequiredArgsConstructor
public class EquipmentService {

    private final  EquipmentRepository equipmentRepository;
    @Transactional
    public EquipmentDto getById(Integer id){
        Optional<EquipmentEntity>entity = equipmentRepository.findById(id);
        if (entity.isPresent()){
            return EquipmentMapper.INSTANCE.toDto(entity.get());
        }
        return null;
    }
    @Transactional
    public EquipmentDto add(EquipmentDto equipmentDto){
        equipmentDto.setId(null);
        EquipmentEntity entity = EquipmentMapper.INSTANCE.toEntity(equipmentDto);
        entity = equipmentRepository.saveAndFlush(entity);
        return EquipmentMapper.INSTANCE.toDto(entity);

    }
    @Transactional
    public EquipmentDto update(EquipmentDto equipmentDto){
        EquipmentEntity entity = EquipmentMapper.INSTANCE.toEntity(equipmentDto);
        entity = equipmentRepository.saveAndFlush(entity);
        return EquipmentMapper.INSTANCE.toDto(entity);
    }
    @Transactional
    public Integer deleteById(Integer id) {
        equipmentRepository.deleteById(id);
        return id;
    }
}



