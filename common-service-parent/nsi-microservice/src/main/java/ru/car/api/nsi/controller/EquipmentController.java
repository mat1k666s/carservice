package ru.car.api.nsi.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.car.api.nsi.dto.CountryDto;
import ru.car.api.nsi.dto.EquipmentDto;
import ru.car.api.nsi.dto.StampAutoDto;
import ru.car.api.nsi.service.EquipmentService;
@RestController
@CrossOrigin
@RequestMapping(value = "/api/nsi/equipment", produces = MediaType.APPLICATION_JSON_VALUE)
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @ApiOperation(value = "получение записи по Id")
//   @ApiResponse({
//            @ApiResponse(code = 200, message = "Успешно")
//            @ApiResponse(code = 204, message = "Запись не найдена")
//           @ApiResponse(code = 500, message = "Внутренняя ошибка сервера")
//   })
    @GetMapping("/{id}")
    @ResponseBody
    public EquipmentDto getById(@PathVariable("id") Integer id) {
        return equipmentService.getById(id);
    }

    @ApiOperation(value = "добавление записи")

    @PostMapping("/add")
    @ResponseBody()
    public EquipmentDto add(@RequestBody EquipmentDto equipmentDto) {
        return equipmentService.add(equipmentDto);
    }

    @ApiOperation(value = "обновление записи")

    @PutMapping("/update")
    @ResponseBody()
    public EquipmentDto update(@RequestBody EquipmentDto equipmentDto) {
        return equipmentService.update(equipmentDto);
    }

    @ApiOperation(value = "удаление записи")

    @DeleteMapping("/{id}")
    @ResponseBody()
    public Integer deleteById(@PathVariable("id") Integer id) {
        return equipmentService.deleteById(id);
    }
}
