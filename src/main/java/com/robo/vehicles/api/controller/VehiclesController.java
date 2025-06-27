package com.robo.vehicles.api.controller;

import com.robo.vehicles.domain.NotFoundException;
import com.robo.vehicles.domain.RegistrationNumber;
import com.robo.vehicles.domain.VehicleFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehiclesController {
    @Autowired
    private VehicleFinder vehicleFinder;

    @GetMapping("/vehicles/{regNo}")
    public VehicleJson oneVehicle(@PathVariable String regNo) {
        return vehicleFinder.find(RegistrationNumber.parse(regNo))
                .map(VehicleJson::from)
                .orElseThrow(() -> new NotFoundException("No vehicle found with reg no " + regNo));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public void handleNotFoundException() {
        // ...
    }
}
