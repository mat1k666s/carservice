package ru.car.api.nsi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.car.api.nsi.filtr.stampAuto.StampAutoFilter;
import ru.car.api.nsi.service.StampAutoService;
import ru.car.dto.nsi.StampAutoDto;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/nsi/stampauto", produces = MediaType.APPLICATION_JSON_VALUE)
public class StampAutoController {
    @Autowired
    private StampAutoService stampAutoService;


    @Operation(summary = "получение записи по Id")
    @ApiResponse(responseCode = "200", description = "Успешно")
    @ApiResponse(responseCode = "204", description = "Запись не найдена")
    @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    @GetMapping("/{id}")
    @ResponseBody
    public StampAutoDto getById(@PathVariable("id") Integer id) {
        return stampAutoService.getById(id);
    }

    @Operation(summary = "добавление записи")
    @PostMapping("/add")
    @ResponseBody()
    public StampAutoDto add(@RequestBody StampAutoDto stampAutoDto) {
        return stampAutoService.add(stampAutoDto);
    }

    @Operation(summary = "обновление записи")
    @PutMapping("/update")
    @ResponseBody()
    public StampAutoDto update(@RequestBody StampAutoDto stampAutoDto) {
        return stampAutoService.update(stampAutoDto);
    }

    @Operation(summary = "удаление записи")
    @DeleteMapping("/{id}")
    @ResponseBody()
    public Integer deleteById(@PathVariable("id") Integer id) {
        return stampAutoService.deleteById(id);
    }

    @Operation(summary = "Наименование страны")
    @GetMapping("/findLikeCountryName")
    @ResponseBody
    public List<StampAutoDto> findLikeCountryName(@RequestParam ("countryName")String countryName){
        return stampAutoService.findLikeCountryName(countryName);
    }
    @Operation(summary = "Обновление страны по ID")
    @GetMapping("/setCountryById")
    @ResponseBody
    public List<StampAutoDto> setCountryById(@RequestParam ("country")String country, @RequestParam ("id")Integer id){
        return stampAutoService.setCountryById(country,id);
    }
    @Operation
    @GetMapping
    @ResponseBody
    public Page<StampAutoDto> getStampAutoPage(Pageable pageable, StampAutoFilter stampAutoFilter){
        return stampAutoService.getStampAutoPage(stampAutoFilter, pageable);
    }


}
