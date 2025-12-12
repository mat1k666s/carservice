package ru.car.api.claim.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.car.api.claim.dto.OrderDto;
import ru.car.api.claim.entity.OrderEntity;
import ru.car.api.claim.filtr.OrderFilter;
import ru.car.api.claim.mapper.OrderMapper;
import ru.car.api.claim.repository.OrderRepository;

import java.util.Optional;

@Repository
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;



    @Transactional
    public Page<OrderDto>getOrderPage(Pageable pageable, OrderFilter orderFilter){
        Page<OrderEntity>entities = orderRepository.findAll(pageable);
        Page<OrderDto>dtos = entities.map(v -> OrderMapper.INSTANCE.toDto(v));
        return dtos;
    }


    @Transactional
    public OrderDto create(OrderDto orderDto){
        Optional<OrderEntity>entity = orderRepository.findById(orderDto.getId());
        if(entity.isPresent()){
            return OrderMapper.INSTANCE.toDto(entity.get());

        }
        return null;
    }
    @Transactional
    public OrderDto update(OrderDto orderDto) {
        OrderEntity entity = OrderMapper.INSTANCE.toEntity(orderDto);
        entity = orderRepository.saveAndFlush(entity);
        return OrderMapper.INSTANCE.toDto(entity);

    }

    @Transactional
    public Integer deleteById(Integer id) {
        orderRepository.deleteById(id);
        return id;
    }
}
