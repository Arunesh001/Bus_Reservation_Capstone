package com.bus_reservation_system.model;


import ch.qos.logback.core.status.Status;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@Document(collection = "bookings")
@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Builder
public class Booking {
    @Id
    private String id;

    @DBRef
    private Trip trip;


    private String userId;


    @Min(value = 1)
    @Max(value = 25)
    private Set<Integer> seatNumbers = new HashSet<>();

    private String bookedAt;

    private String status;

    public Booking() {
    }

    public Booking(String id, Trip trip, String userId, Set<Integer> seatNumbers, String bookedAt, String status) {
        this.id = id;
        this.trip = trip;
        this.userId = userId;
        this.seatNumbers = seatNumbers;
        this.bookedAt = bookedAt;
        this.status = status;
    }

}
