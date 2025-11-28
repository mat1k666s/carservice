package ru.car.api.nsi.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.car.api.nsi.dto.CountryDto;
import ru.car.api.nsi.dto.ServiceDto;
import ru.car.api.nsi.dto.StampAutoDto;
import ru.car.api.nsi.service.ServiceService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/nsi/service", produces = MediaType.APPLICATION_JSON_VALUE)
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @ApiOperation(value = "получение записи по Id")
//   @ApiResponse({
//            @ApiResponse(code = 200, message = "Успешно")
//            @ApiResponse(code = 204, message = "Запись не найдена")
//           @ApiResponse(code = 500, message = "Внутренняя ошибка сервера")
//   })
    @GetMapping("/{id}")
    @ResponseBody
    public ServiceDto getById(@PathVariable("id") Integer id) {
        return serviceService.getById(id);
    }

    @ApiOperation(value = "добавление записи")

    @PostMapping("/add")
    @ResponseBody()
    public ServiceDto add(@RequestBody ServiceDto serviceDto) {
        return serviceService.add(serviceDto);
    }

    @ApiOperation(value = "обновление записи")

    @PutMapping("/update")
    @ResponseBody()
    public ServiceDto update(@RequestBody ServiceDto serviceDto) {
        return serviceService.update(serviceDto);
    }

    @ApiOperation(value = "удаление записи")

    @DeleteMapping("/{id}")
    @ResponseBody()
    public Integer deleteById(@PathVariable("id") Integer id) {
        return serviceService.deleteById(id);
    }

}
