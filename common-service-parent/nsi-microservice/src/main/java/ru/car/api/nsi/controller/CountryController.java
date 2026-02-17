package ru.car.api.nsi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.car.api.nsi.filtr.country.CountryFilter;
import ru.car.api.nsi.service.CountryService;
import ru.car.dto.nsi.CountryDto;
import ru.car.dto.nsi.StampAutoDto;

import java.util.List;

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
    @Operation(summary = "Фильтрация стран по короткому названию")
    @GetMapping("/findByShortName")
    @ResponseBody
    public List<CountryDto> findByShortName(@RequestParam ("shortName")String shortName) {
        return countryService.findLikeShortName(shortName);
    }
    @GetMapping("/getOrderPage")
    @ResponseBody
    public Page<CountryDto> getOrderPage(Pageable pageable, CountryFilter countryFilter) {
        return countryService.getOrderPage(pageable, countryFilter);
    }
}
