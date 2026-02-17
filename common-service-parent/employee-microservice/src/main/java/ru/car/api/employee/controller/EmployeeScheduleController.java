package ru.car.api.employee.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.car.api.employee.entity.EmployeeEntity;
import ru.car.api.employee.service.EmployeeScheduleService;
import ru.car.employee.dto.EmployeeScheduleDto;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/employee/employee_schedule", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeScheduleController {
    @Autowired
    private EmployeeScheduleService employeeScheduleService;

    @Operation(summary = "получение записи по Id")
    @ApiResponse(responseCode = "200", description = "Успешно")
    @ApiResponse(responseCode = "204", description = "Запись не найдена")
    @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    @GetMapping("/{id}")
    @ResponseBody
    public EmployeeScheduleDto getById(@PathVariable("id") Integer id) {
        return employeeScheduleService.getById(id);
    }

    @Operation(summary = "добавление записи")
    @PostMapping("/add")
    @ResponseBody()
    public EmployeeScheduleDto add(@RequestBody EmployeeScheduleDto employeeScheduleDto) {
        return employeeScheduleService.add(employeeScheduleDto);
    }

    @Operation(summary = "обновление записи")
    @PutMapping("/update")
    @ResponseBody()
    public EmployeeScheduleDto update(@RequestBody EmployeeScheduleDto employeeScheduleDto) {
        return employeeScheduleService.update(employeeScheduleDto);
    }

    @Operation(summary = "удаление записи")
    @DeleteMapping("/{id}")
    @ResponseBody()
    public Integer deleteById(@PathVariable("id") Integer id) {
        return employeeScheduleService.deleteById(id);
    }

    @Operation(summary = "Роль по коду")
    @GetMapping("/findByEmployeeId")
    @ResponseBody
    public List<EmployeeScheduleDto> findByEmployeeId(@RequestParam EmployeeEntity employeeId) {
        return employeeScheduleService.findByEmployeeId(employeeId);

    }

}
