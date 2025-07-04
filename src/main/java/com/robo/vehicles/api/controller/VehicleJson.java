package com.robo.vehicles.api.controller;

import com.robo.vehicles.domain.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehicleJson {
    private String registrationNumber;
    private String type;

    public static VehicleJson from(Vehicle vehicle) {
        return new VehicleJson(vehicle.registrationNumber.value, vehicle.type);
    }
}
