package ru.car.api.employee.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.car.api.employee.entity.EmployeeEntity;
import ru.car.api.employee.service.EmployeeSkillService;
import ru.car.employee.dto.EmployeeSkillDto;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(value = "/api/employee/employee_skill", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeSkillController {
    @Autowired
    private EmployeeSkillService employeeSkillService;


    @Operation(summary = "получение записи по Id")
    @ApiResponse(responseCode = "200", description = "Успешно")
    @ApiResponse(responseCode = "204", description = "Запись не найдена")
    @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    @GetMapping("/{id}")
    @ResponseBody
    public EmployeeSkillDto getById(@PathVariable("id") Integer id) {
        return employeeSkillService.getById(id);
    }

    @Operation(summary = "добавление записи")
    @PostMapping("/add")
    @ResponseBody()
    public EmployeeSkillDto add(@RequestBody EmployeeSkillDto employeeSkillDto) {
        return employeeSkillService.add(employeeSkillDto);
    }

    @Operation(summary = "обновление записи")
    @PutMapping("/update")
    @ResponseBody()
    public EmployeeSkillDto update(@RequestBody EmployeeSkillDto employeeSkillDto) {
        return employeeSkillService.update(employeeSkillDto);
    }

    @Operation(summary = "удаление записи")
    @DeleteMapping("/{id}")
    @ResponseBody()
    public Integer deleteById(@PathVariable("id") Integer id) {
        return employeeSkillService.deleteById(id);
    }

    @Operation(summary = "Роль по id")
    @GetMapping("/indByEmployeeId")
    @ResponseBody
    public List<EmployeeSkillDto> findByEmployeeId(@RequestParam EmployeeEntity employeeId) {
        return employeeSkillService.findByEmployeeId(employeeId);

    }

    @Operation(summary = "Роль по коду")
    @GetMapping("/findBySkillCode")
    @ResponseBody
    public List<EmployeeSkillDto> findBySkillCode(@RequestParam String skillCode) {
        return employeeSkillService.findBySkillCode(skillCode);
    }
}
