package ru.car.api.nsi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.car.api.nsi.dto.CountryDto;
import ru.car.api.nsi.service.CountryService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/nsi/country", produces = MediaType.APPLICATION_JSON_VALUE)
public class CountryController {
    @Autowired
    private CountryService countryService;

    @Operation(summary = "получение записи по Id")
    @ApiResponse(responseCode = "200", description = "Успешно")
    @ApiResponse(responseCode = "204", description = "Запись не найдена")
    @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    @GetMapping("/{id}")
    @ResponseBody
    public CountryDto getById(@PathVariable("id") Integer id) {
        return countryService.getById(id);
    }

    @Operation(summary = "добавление записи")
    @PostMapping("/add")
    @ResponseBody()
    public CountryDto add(@RequestBody CountryDto countryDto) {
        return countryService.add(countryDto);
    }

    @Operation(summary = "обновление записи")
    @PutMapping("/update")
    @ResponseBody()
    public CountryDto update(@RequestBody CountryDto countryDto) {
        return countryService.update(countryDto);
    }

    @Operation(summary = "удаление записи")
    @DeleteMapping("/{id}")
    @ResponseBody()
    public Integer deleteById(@PathVariable("id") Integer id) {
        return countryService.deleteById(id);
    }


}
