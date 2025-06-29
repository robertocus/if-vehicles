package com.robo.vehicles.api.controller;

import com.robo.vehicles.domain.Vehicle;
import com.robo.vehicles.domain.VehicleFinder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = {VehiclesController.class})
class VehiclesControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private VehicleFinder vehicleFinder;

    @Test
    public void whenFindExistingVehicle() throws Exception {
        when(this.vehicleFinder.find(any())).thenReturn(Optional.of(Vehicle.ABC));

        this.mockMvc.perform(get("/vehicles/ABC123"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.registrationNumber").value(Vehicle.ABC.registrationNumber.value));

        verify(this.vehicleFinder, times(1)).find(any());
    }

    @Test
    public void whenFindNoneExistingVehicle() throws Exception {
        when(this.vehicleFinder.find(any())).thenReturn(Optional.empty());

        this.mockMvc.perform(get("/vehicles/ABC123")).andExpect(status().isNotFound());

        verify(this.vehicleFinder, times(1)).find(any());
    }
}