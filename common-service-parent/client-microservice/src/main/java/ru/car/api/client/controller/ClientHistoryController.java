package ru.car.api.client.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.car.api.client.InteractionType;
import ru.car.api.client.dto.ClientHistoryDto;

import ru.car.api.client.service.ClientHistoryService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/client/clienthist", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientHistoryController {
    @Autowired
    private ClientHistoryService clientHistoryService;
    @Operation(summary = "получение записи по Id")
    @ApiResponse(responseCode = "200", description = "Успешно")
    @ApiResponse(responseCode = "204", description = "Запись не найдена")
    @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    @GetMapping("/{id}")
    @ResponseBody
    public ClientHistoryDto getById(@PathVariable("id") Integer id) {
        return clientHistoryService.getById(id);

    }

    @Operation(summary = "добавление записи")
    @PostMapping("/add")
    @ResponseBody()
    public ClientHistoryDto add(@RequestBody ClientHistoryDto clientHistoryDto) {
        return clientHistoryService.add(clientHistoryDto);
    }

    @Operation(summary = "обновление записи")
    @PutMapping("/update")
    @ResponseBody()
    public ClientHistoryDto update(@RequestBody ClientHistoryDto clientHistoryDto) {
        return clientHistoryService.update(clientHistoryDto);
    }


    @Operation(summary = "удаление записи")
    @DeleteMapping("/{id}")
    @ResponseBody()
    public Integer deleteById(@PathVariable("id") Integer id) {
        return clientHistoryService.deleteById(id);
    }

    @Operation(summary = "Начало и конец")
    @GetMapping("/findByRegistrationDateBetween")
    @ResponseBody
    public List<ClientHistoryDto> findByRegistrationDateBetween(LocalDateTime start, LocalDateTime end) {
        return clientHistoryService.findByRegistrationDateBetween(start, end);
    }

    @Operation(summary = "Поиск клиента по id")
    @GetMapping("/findByClientId")
    @ResponseBody
    public List<ClientHistoryDto> findByClientId(Integer clientId) {
        return clientHistoryService.findByClientId(clientId);
    }

    @Operation(summary = "Вид работы")
    @GetMapping("/findByInteractionType")
    @ResponseBody
    public List<ClientHistoryDto> findByInteractionType(InteractionType interactionType) {
        return clientHistoryService.findByInteractionType(interactionType);

    }

    
}
