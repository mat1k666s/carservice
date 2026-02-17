package ru.car.api.client.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import ru.car.api.client.ClientStatus;
import ru.car.api.client.dto.ClientDto;
import ru.car.api.client.service.ClientService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/client/client", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {
    @Autowired
    private ClientService clientService;

    @Operation(summary = "получение записи по Id")
    @ApiResponse(responseCode = "200", description = "Успешно")
    @ApiResponse(responseCode = "204", description = "Запись не найдена")
    @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    @GetMapping("/{id}")
    @ResponseBody
    public ClientDto getById(@PathVariable("id") Integer id) {
        return clientService.getById(id);

    }

    @Operation(summary = "добавление записи")
    @PostMapping("/add")
    @ResponseBody()
    public ClientDto add(@RequestBody ClientDto clientDto) {
        return clientService.add(clientDto);
    }

    @Operation(summary = "обновление записи")
    @PutMapping("/update")
    @ResponseBody()
    public ClientDto update(@RequestBody ClientDto clientDto) {
        return clientService.update(clientDto);
    }


    @Operation(summary = "удаление записи")
    @DeleteMapping("/{id}")
    @ResponseBody()
    public Integer deleteById(@PathVariable("id") Integer id) {
        return clientService.deleteById(id);
    }

    @Operation(summary = "Поиск по имени")
    @GetMapping
    @ResponseBody
    public List<ClientDto> findByFirstNameContainingIgnoreCase(@RequestParam String firstName) {
        return clientService.findByFirstNameContainingIgnoreCase(firstName);
    }

    @Operation(summary = "Поиск по фамилии")
    @GetMapping("/findByLastNameContainingIgnoreCase")
    @ResponseBody
    public List<ClientDto> findByLastNameContainingIgnoreCase(@RequestParam String lastName) {
        return clientService.findByLastNameContainingIgnoreCase(lastName);
    }

    @Operation(summary = "Поиск по отчеству")
    @GetMapping("/findByMiddleNameAndLastNameContainingIgnoreCase")
    @ResponseBody
    public List<ClientDto> findByMiddleNameAndLastNameContainingIgnoreCase(@RequestParam String middleName) {
        return clientService.findByMiddleNameContainingIgnoreCase(middleName);

    }

    @Operation(summary = "Номер телефона")
    @GetMapping("/findLikePhone")
    @ResponseBody
    public List<ClientDto> findLikePhone(@RequestParam String phone) {
        return clientService.findLikePhone(phone);
    }

    @Operation(summary = "Почта по адрессу")
    @GetMapping("/findByAddress")
    @ResponseBody
    public List<ClientDto> findByAddress(@RequestParam String address, @RequestParam String email) {
        return clientService.setAddress(address, email);


    }
    @Operation(summary = "Имя, Фамилия ")
    @GetMapping("/findByLastNameAndFirstName")
    @ResponseBody
    public List<ClientDto> findByLastNameAndFirstName(@RequestParam String lastName, @RequestParam String firstName) {
        return clientService.findByLastNameAndFirstName(lastName, firstName);
    }
    @Operation(summary = "начало и конец ")
    @GetMapping("/findByCreatedAtBetween")
    @ResponseBody
    public List<ClientDto> findByCreatedAtBetween(@RequestParam LocalDateTime start, @RequestParam LocalDateTime end) {
        return clientService.findByCreatedAtBetween(start, end);
    }
    @Operation(summary = "Статус клиента ")
    @GetMapping("/countByStatus")
    @ResponseBody
    public List<ClientDto> countByStatus(@RequestParam ClientStatus status) {
        return clientService.countByStatus(status);
    }



}
