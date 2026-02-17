package ru.car.api.nsi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import ru.car.api.nsi.filtr.service.ServiceFilter;
import ru.car.api.nsi.service.ServiceService;
import ru.car.dto.nsi.ServiceDto;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/nsi/service", produces = MediaType.APPLICATION_JSON_VALUE)
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @Operation(summary = "получение записи по Id")
    @ApiResponse(responseCode = "200", description = "Успешно")
    @ApiResponse(responseCode = "204", description = "Запись не найдена")
    @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    @GetMapping("/{id}")
    @ResponseBody
    public ServiceDto getById(@PathVariable("id") Integer id) {
        return serviceService.getById(id);
    }

    @Operation(summary = "добавление записи")
    @PostMapping("/add")
    @ResponseBody()
    public ServiceDto add(@RequestBody ServiceDto serviceDto) {
        return serviceService.add(serviceDto);
    }

    @Operation(summary = "обновление записи")
    @PutMapping("/update")
    @ResponseBody()
    public ServiceDto update(@RequestBody ServiceDto serviceDto) {
        return serviceService.update(serviceDto);
    }

    @Operation(summary = "удаление записи")
    @DeleteMapping("/{id}")
    @ResponseBody()
    public Integer deleteById(@PathVariable("id") Integer id) {
        return serviceService.deleteById(id);
    }

    @Operation(summary = "Короткое название")
    @DeleteMapping("/{findLikeShortName}")
    @ResponseBody()
    public List<ServiceDto> findLikeShortName(@PathVariable("shortName") String shortName){
        return serviceService.findLikeShortName(shortName);
    }
    @GetMapping("/getServicePage")
    @ResponseBody
    public Page<ServiceDto> getServicePage(Pageable pageable, ServiceFilter serviceFilter){
        return serviceService.getServicePage(pageable,serviceFilter);

    }

}
