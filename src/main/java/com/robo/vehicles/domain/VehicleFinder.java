package com.robo.vehicles.domain;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.Optional;

@AllArgsConstructor
public class VehicleFinder {
    // Detta är en så kallad "Service" men då jag ogillar Service klasser så föredrar jag att skapa en specifik logikklass
    // med namn efter vad den gör och utan extra beroenden till andra "service" metoder i samma klass.
    // Detta är domän logik och här hemma i domänen.
    // Domän klasser har inte beroende till några andra paket. infrastructure, api, config kan alla referera domän.
    @NonNull
    private VehicleRepository vehicleRepository;

    public Optional<Vehicle> find(@NonNull RegistrationNumber regNo) {
        return vehicleRepository.find(regNo);
    }
}
