package com.robo.vehicles.infrastructure.db;

import com.robo.vehicles.domain.RegistrationNumber;
import com.robo.vehicles.domain.Vehicle;
import com.robo.vehicles.domain.VehicleRepository;
import lombok.NonNull;

import java.util.Optional;

public class VehicleRepositoryStatic implements VehicleRepository {

    @Override
    public Optional<Vehicle> find(@NonNull RegistrationNumber regNo) {
        // I riktig databas implementation så skulle det finnas egen databas klass för VehicleDB
        // som mappas till domän klassen Vehicle
        return regNo.equals(RegistrationNumber.ABC) ? Optional.of(Vehicle.ABC) :
                regNo.equals(RegistrationNumber.DEF) ? Optional.of(Vehicle.DEF) : Optional.empty();
    }
}
