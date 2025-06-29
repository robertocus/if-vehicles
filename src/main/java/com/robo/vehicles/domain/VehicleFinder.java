package com.robo.vehicles.domain;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.Optional;

@AllArgsConstructor
public class VehicleFinder {
    // Detta är en så kallad "Service" men då jag ogillar Service klasser så har jag en egen Finder som inte får en massa
    // extra beroenden beroende på service metoden som en traditionell "Service" och du kan skapa andra specifika logik klasser i domänen.
    // VehicleFinder(VehicleService) och Vehicle är båda domän.
    // Domän klasser har inte beroende till några andra paket. infrastructure, api, config kan alla referera domän.
    @NonNull
    private VehicleRepository vehicleRepository;

    public Optional<Vehicle> find(@NonNull RegistrationNumber regNo) {
        return vehicleRepository.find(regNo);
    }
}
