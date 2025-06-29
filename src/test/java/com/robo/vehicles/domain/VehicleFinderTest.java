package com.robo.vehicles.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class VehicleFinderTest {
    private VehicleFinder vehicleFinder;
    private VehicleRepository vehicleRepositoryMock;

    @BeforeEach
    void setUpFinder() {
        vehicleRepositoryMock = mock(VehicleRepository.class);
        vehicleFinder = new VehicleFinder(vehicleRepositoryMock);
    }

    @Test
    public void whenFindExistingVehicle() {
        when(vehicleRepositoryMock.find(RegistrationNumber.ABC)).thenReturn(Optional.of(Vehicle.ABC));

        assertThat(vehicleFinder.find(RegistrationNumber.ABC)).isPresent().hasValue(Vehicle.ABC);
    }

    @Test
    public void whenFindNoneExistingVehicle() {
        when(vehicleRepositoryMock.find(RegistrationNumber.ABC)).thenReturn(Optional.empty());

        assertThat(vehicleFinder.find(RegistrationNumber.ABC)).isEmpty();
    }
}