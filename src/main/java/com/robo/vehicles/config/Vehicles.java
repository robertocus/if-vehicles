package com.robo.vehicles.config;

import com.robo.vehicles.domain.VehicleFinder;
import com.robo.vehicles.domain.VehicleRepository;
import com.robo.vehicles.infrastructure.db.VehicleRepositoryStatic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Vehicles {

    @Bean
    public VehicleRepository vehicleRepository() {
        return new VehicleRepositoryStatic();
    }

    @Bean
    public VehicleFinder vehicleFinder(VehicleRepository vehicleRepository) {
        return new VehicleFinder(vehicleRepository);
    }
}
