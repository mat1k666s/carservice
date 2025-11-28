package ru.car.api.nsi.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
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

    @ApiOperation(value = "получение записи по Id")
//   @ApiResponse({
//            @ApiResponse(code = 200, message = "Успешно")
//            @ApiResponse(code = 204, message = "Запись не найдена")
//           @ApiResponse(code = 500, message = "Внутренняя ошибка сервера")
//   })
    @GetMapping("/{id}")
    @ResponseBody
    public CountryDto getById(@PathVariable("id") Integer id) {
        return countryService.getById(id);
    }

    @ApiOperation(value = "добавление записи")

    @PostMapping("/add")
    @ResponseBody()
    public CountryDto add(@RequestBody CountryDto countryDto) {
        return countryService.add(countryDto);
    }

    @ApiOperation(value = "обновление записи")

    @PutMapping("/update")
    @ResponseBody()
    public CountryDto update(@RequestBody CountryDto countryDto) {
        return countryService.update(countryDto);
    }

    @ApiOperation(value = "удаление записи")

    @DeleteMapping("/{id}")
    @ResponseBody()
    public Integer deleteById(@PathVariable("id") Integer id) {
        return countryService.deleteById(id);
    }


}
