package ru.car.api.claim.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import ru.car.api.claim.filtr.OrderFilter;
import ru.car.api.claim.service.OrderService;
import ru.car.dto.claim.OrderDto;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/claim/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Operation(summary = "получение записи по заявке")
    @ApiResponse(responseCode = "200", description = "Успешно")
    @ApiResponse(responseCode = "204", description = "Запись не найдена")
    @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    @GetMapping("/getOrderPage")
    @ResponseBody
    public Page<OrderDto> getOrderPage(Pageable pageable, OrderFilter orderFilter) {
        return orderService.getOrderPage(pageable, orderFilter);
    }

    @Operation(summary = "добавление записи")
    @PostMapping("/add")
    @ResponseBody()
    public OrderDto create(@RequestBody OrderDto orderDto) {
        return orderService.create(orderDto);
    }

    @Operation(summary = "обновление записи")
    @PutMapping("/update")
    @ResponseBody()
    public OrderDto update(@RequestBody OrderDto orderDto) {
        return orderService.update(orderDto);
    }

    @Operation(summary = "удаление записи")
    @DeleteMapping("/{id}")
    @ResponseBody()
    public Integer deleteById(@PathVariable("id") Integer id) {
        return orderService.deleteById(id);
    }

    @Operation(summary = "Наименование по фамилии")
    @GetMapping("/findLikeFullName")
    @ResponseBody
    public List<OrderDto> findLikeFullName(@RequestParam("fullName") String fullName) {
        return orderService.findLikeFullName(fullName);
    }

    @Operation(summary = "")
    @GetMapping("/setAddress")
    @ResponseBody
    public List<OrderDto> setAddress(@RequestParam("phone") String address, @RequestParam("phone") String phone) {
        return orderService.setAddress(address, phone);
    }
}
