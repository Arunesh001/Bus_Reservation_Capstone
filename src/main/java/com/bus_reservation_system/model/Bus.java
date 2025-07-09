package com.bus_reservation_system.model;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;

@Setter
@Getter
@Document(collection = "buses")
//@Data @NoArgsConstructor
//@AllArgsConstructor
@Builder
public class Bus {
    @Id
    private String id;

    @NotBlank(message = "BusNum should not blank")
    private String busNumber;

    @NotBlank(message = "operator should not blank")
    private String operator;


    private int totalSeats;

    @NotBlank(message = "departureTime should not blank")
    private String departureTime;


    @NotBlank(message = "arrivalTime should not blank")
    private String arrivalTime;


    private String tripId;

    public Bus() {
    }

    public Bus(String id, String busNumber, String operator, int totalSeats, String departureTime, String arrivalTime, String tripId) {
        this.id = id;
        this.busNumber = busNumber;
        this.operator = operator;
        this.totalSeats = totalSeats;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.tripId = tripId;
    }

}

