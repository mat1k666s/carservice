package ru.car.api.employee.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import ru.car.api.employee.EmployeeStatus;
import ru.car.api.employee.service.EmployeeService;
import ru.car.employee.dto.EmployeeDto;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/employee/employee", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Operation(summary = "получение записи по Id")
    @ApiResponse(responseCode = "200", description = "Успешно")
    @ApiResponse(responseCode = "204", description = "Запись не найдена")
    @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    @GetMapping("/{id}")
    @ResponseBody
    public EmployeeDto getById(@PathVariable("id") Integer id) {
        return employeeService.getById(id);
    }

    @Operation(summary = "добавление записи")
    @PostMapping("/add")
    @ResponseBody()
    public EmployeeDto add(@RequestBody EmployeeDto employeeDto) {
        return employeeService.add(employeeDto);
    }

    @Operation(summary = "обновление записи")
    @PutMapping("/update")
    @ResponseBody()
    public EmployeeDto update(@RequestBody EmployeeDto employeeDto) {
        return employeeService.update(employeeDto);
    }

    @Operation(summary = "удаление записи")
    @DeleteMapping("/{id}")
    @ResponseBody()
    public Integer deleteById(@PathVariable("id") Integer id) {
        return employeeService.deleteById(id);
    }

    @Operation(summary = "Поиск по статусу")
    @GetMapping("/findByStatus")
    @ResponseBody
    public List<EmployeeDto> findByStatus(@RequestParam EmployeeStatus status) {
        return employeeService.findByStatus(status);
    }

    @Operation(summary = "Роль")
    @GetMapping("/findByRoleId")
    @ResponseBody
    public List<EmployeeDto> findByRoleId(@RequestParam Integer roleId) {
        return employeeService.findByRoleId(roleId);
    }

    @Operation(summary = "Роль по коду")
    @GetMapping("/findByHireDate")
    @ResponseBody
    public List<EmployeeDto> findByHireDate(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return employeeService.findByHireDate(startDate, endDate);
    }

}
