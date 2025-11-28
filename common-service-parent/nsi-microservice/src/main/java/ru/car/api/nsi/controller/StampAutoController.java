package ru.car.api.nsi.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.car.api.nsi.dto.CountryDto;
import ru.car.api.nsi.dto.StampAutoDto;
import ru.car.api.nsi.service.StampAutoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/nsi/stampauto", produces = MediaType.APPLICATION_JSON_VALUE)
public class StampAutoController {
    @Autowired
    private StampAutoService stampAutoService;


    @ApiOperation(value = "получение записи по Id")
//   @ApiResponse({
//            @ApiResponse(code = 200, message = "Успешно")
//            @ApiResponse(code = 204, message = "Запись не найдена")
//           @ApiResponse(code = 500, message = "Внутренняя ошибка сервера")
//   })
    @GetMapping("/{id}")
    @ResponseBody
    public StampAutoDto getById(@PathVariable("id") Integer id) {
        return stampAutoService.getById(id);
    }

    @ApiOperation(value = "добавление записи")

    @PostMapping("/add")
    @ResponseBody()
    public StampAutoDto add(@RequestBody StampAutoDto stampAutoDto) {
        return stampAutoService.add(stampAutoDto);
    }

    @ApiOperation(value = "обновление записи")

    @PutMapping("/update")
    @ResponseBody()
    public StampAutoDto update(@RequestBody StampAutoDto stampAutoDto) {
        return stampAutoService.update(stampAutoDto);
    }

    @ApiOperation(value = "удаление записи")

    @DeleteMapping("/{id}")
    @ResponseBody()
    public Integer deleteById(@PathVariable("id") Integer id) {
        return stampAutoService.deleteById(id);
    }


}
