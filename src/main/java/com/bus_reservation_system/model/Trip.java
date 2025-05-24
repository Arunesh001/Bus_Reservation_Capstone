package com.bus_reservation_system.model;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Document(collection = "trips")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trip {
    @Id
    private String id;




    @NotBlank(message = "source should not blank")
    private String source;

    @NotBlank(message = "destination should not blank")
    private String destination;

    @NotBlank(message = "travelDate should not blank")
    private String travelDate;

    @NotBlank(message = "fare should not blank")
    @Min(10)
    private Double fare;

    private Set<Integer> bookedSeats = new HashSet<>();

    @DBRef
    private List<User> users = new ArrayList<>();

    @DBRef
    private Bus bus;
}
