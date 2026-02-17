package ru.car.api.client.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.car.api.client.dto.ClientCarDto;
import ru.car.api.client.service.ClientCarService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/client/client_car", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientCarController {
    @Autowired
    private ClientCarService clientCarService;


    @Operation(summary = "получение записи по Id")
    @ApiResponse(responseCode = "200", description = "Успешно")
    @ApiResponse(responseCode = "204", description = "Запись не найдена")
    @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    @GetMapping("/{id}")
    @ResponseBody
    public ClientCarDto getById(@PathVariable("id") Integer id) {
        return clientCarService.getById(id);
    }

    @Operation(summary = "добавление записи")
    @PostMapping("/add")
    @ResponseBody()
    public ClientCarDto add(@RequestBody ClientCarDto clientCarDto) {
        return clientCarService.add(clientCarDto);
    }

    @Operation(summary = "обновление записи")
    @PutMapping("/update")
    @ResponseBody()
    public ClientCarDto update(@RequestBody ClientCarDto clientCarDto) {
        return clientCarService.update(clientCarDto);
    }


    @Operation(summary = "удаление записи")
    @DeleteMapping("/{id}")
    @ResponseBody()
    public Integer deleteById(@PathVariable("id") Integer id) {
        return clientCarService.deleteById(id);
    }

    @Operation(summary = "Поиск по цвету")
    @GetMapping("/findByColorContainingIgnoreCase")
    @ResponseBody
    public List<ClientCarDto> findByColorContainingIgnoreCase(@RequestParam("country") String country) {
        return clientCarService.findByColorContainingIgnoreCase(country);
    }

    @Operation(summary = "По вин номеру")
    @GetMapping("/findLikeVin ")
    @ResponseBody
    public List<ClientCarDto> findLikeVin (@RequestParam("vin") String vin) {
        return clientCarService.findLikeVin(vin);
    }
    @Operation(summary = "Номер машины , пробег")
    @GetMapping("/setLicensePlate")
    @ResponseBody
    public List<ClientCarDto> setLicensePlate(@RequestParam ("licensePlate") String licensePlate, @RequestParam("mileage")Integer mileage) {
        return clientCarService.setLicensePlate(licensePlate, mileage);
    }

}
