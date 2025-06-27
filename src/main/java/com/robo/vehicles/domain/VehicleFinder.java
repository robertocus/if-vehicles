package com.robo.vehicles.domain;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.Optional;

@AllArgsConstructor
public class VehicleFinder {
    @NonNull
    private VehicleRepository vehicleRepository;

    public Optional<Vehicle> find(@NonNull RegistrationNumber regNo) {
        return vehicleRepository.find(regNo);
    }
}
