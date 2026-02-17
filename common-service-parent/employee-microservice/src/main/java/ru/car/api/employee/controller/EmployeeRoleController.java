package ru.car.api.employee.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.car.api.employee.service.EmployeeRoleService;
import ru.car.employee.dto.EmployeeRoleDto;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/employee/employee_role", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeRoleController {
    @Autowired
    private EmployeeRoleService employeeRoleService;

    @Operation(summary = "получение записи по Id")
    @ApiResponse(responseCode = "200", description = "Успешно")
    @ApiResponse(responseCode = "204", description = "Запись не найдена")
    @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    @GetMapping("/{id}")
    @ResponseBody
    public EmployeeRoleDto getById(@PathVariable("id") Integer id) {
        return employeeRoleService.getById(id);
    }

    @Operation(summary = "добавление записи")
    @PostMapping("/add")
    @ResponseBody()
    public EmployeeRoleDto add(@RequestBody EmployeeRoleDto employeeRoleDto) {
        return employeeRoleService.add(employeeRoleDto);
    }

    @Operation(summary = "обновление записи")
    @PutMapping("/update")
    @ResponseBody()
    public EmployeeRoleDto update(@RequestBody EmployeeRoleDto employeeRoleDto) {
        return employeeRoleService.update(employeeRoleDto);
    }

    @Operation(summary = "удаление записи")
    @DeleteMapping("/{id}")
    @ResponseBody()
    public Integer deleteById(@PathVariable("id") Integer id) {
        return employeeRoleService.deleteById(id);
    }
    @Operation(summary = "По имени")
    @GetMapping
    @ResponseBody
    public List<EmployeeRoleDto> findByName(@RequestParam String name) {
        return employeeRoleService.findByName(name);
    }
    @Operation(summary = "По коду")
    @GetMapping("/findByCode")
    @ResponseBody
    public List<EmployeeRoleDto> findByCode(@RequestParam String code) {
        return employeeRoleService.findByCode(code);
    }

}
