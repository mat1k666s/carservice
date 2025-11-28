package ru.car.api.nsi.controller;

import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "получение записи по Id")
//   @ApiResponse({
//            @ApiResponse(code = 200, message = "Успешно")
//            @ApiResponse(code = 204, message = "Запись не найдена")
//           @ApiResponse(code = 500, message = "Внутренняя ошибка сервера")
//   })
    @GetMapping("/{id}")
    @ResponseBody
    public PartsDto getById(@PathVariable("id") Integer id) {
        return partsService.getById(id);
    }

    @ApiOperation(value = "добавление записи")

    @PostMapping("/add")
    @ResponseBody()
    public PartsDto add(@RequestBody PartsDto partsDto) {
        return partsService.add(partsDto);
    }

    @ApiOperation(value = "обновление записи")

    @PutMapping("/update")
    @ResponseBody()
    public PartsDto update(@RequestBody PartsDto partsDto) {
        return partsService.update(partsDto);
    }

    @ApiOperation(value = "удаление записи")

    @DeleteMapping("/{id}")
    @ResponseBody()
    public Integer deleteById(@PathVariable("id") Integer id) {
        return partsService.deleteById(id);
    }
}
