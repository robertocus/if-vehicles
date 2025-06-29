package com.robo.vehicles.domain;

import lombok.NonNull;
import lombok.Value;

@Value
public class Vehicle {
    public static final Vehicle ABC = new Vehicle(RegistrationNumber.ABC, "Volvo");
    public static final Vehicle DEF = new Vehicle(RegistrationNumber.DEF, "Saab");

    @NonNull
    public RegistrationNumber registrationNumber;
    @NonNull
    public String type;
}
