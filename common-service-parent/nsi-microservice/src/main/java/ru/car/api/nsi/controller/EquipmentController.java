package ru.car.api.nsi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.car.api.nsi.service.EquipmentService;
import ru.car.dto.nsi.EquipmentDto;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/nsi/equipment", produces = MediaType.APPLICATION_JSON_VALUE)
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @Operation(summary = "получение записи по Id")
    @ApiResponse(responseCode = "200", description = "Успешно")
    @ApiResponse(responseCode = "204", description = "Запись не найдена")
    @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    @GetMapping("/{id}")
    @ResponseBody
    public EquipmentDto getById(@PathVariable("id") Integer id) {
        return equipmentService.getById(id);
    }

    @Operation(summary = "добавление записи")
    @PostMapping("/add")
    @ResponseBody()
    public EquipmentDto add(@RequestBody EquipmentDto equipmentDto) {
        return equipmentService.add(equipmentDto);
    }

    @Operation(summary = "обновление записи")
    @PutMapping("/update")
    @ResponseBody()
    public EquipmentDto update(@RequestBody EquipmentDto equipmentDto) {
        return equipmentService.update(equipmentDto);
    }

    @Operation(summary = "удаление записи")
    @DeleteMapping("/{id}")
    @ResponseBody()
    public Integer deleteById(@PathVariable("id") Integer id) {
        return equipmentService.deleteById(id);
    }
}
