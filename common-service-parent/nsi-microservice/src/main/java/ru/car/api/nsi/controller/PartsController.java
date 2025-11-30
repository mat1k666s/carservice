package ru.car.api.nsi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.car.api.nsi.dto.PartsDto;
import ru.car.api.nsi.service.PartsService;
@RestController
@CrossOrigin
@RequestMapping(value = "/api/nsi/parts", produces = MediaType.APPLICATION_JSON_VALUE)
public class PartsController {
    @Autowired
    private PartsService partsService;

    @Operation(summary = "получение записи по Id")
    @ApiResponse(responseCode = "200", description = "Успешно")
    @ApiResponse(responseCode = "204", description = "Запись не найдена")
    @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    @GetMapping("/{id}")
    @ResponseBody
    public PartsDto getById(@PathVariable("id") Integer id) {
        return partsService.getById(id);
    }

    @Operation(summary = "добавление записи")
    @PostMapping("/add")
    @ResponseBody()
    public PartsDto add(@RequestBody PartsDto partsDto) {
        return partsService.add(partsDto);
    }

    @Operation(summary = "обновление записи")
    @PutMapping("/update")
    @ResponseBody()
    public PartsDto update(@RequestBody PartsDto partsDto) {
        return partsService.update(partsDto);
    }

    @Operation(summary = "удаление записи")
    @DeleteMapping("/{id}")
    @ResponseBody()
    public Integer deleteById(@PathVariable("id") Integer id) {
        return partsService.deleteById(id);
    }
}
