package com.robo.vehicles.domain;

import java.util.Optional;

public interface VehicleRepository {
    Optional<Vehicle> find(RegistrationNumber registrationNumber);
}
