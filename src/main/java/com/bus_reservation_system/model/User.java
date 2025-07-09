package com.bus_reservation_system.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Document(collection = "users")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Builder
public class User {
    @Id
    private String id;

    @NotBlank(message = "Username should not be blank")
    private String username;
    @NotBlank(message = "password should not be blank")
    private String password;

    @NotBlank(message = "Email should not be blank")
    @Email
    private String email;

    @NotBlank(message = "Role should not be blank")
    private String roles;

    private boolean enabled = true;

    @NotBlank(message = "Gender should not be blank")
    private String gender;

    @Min(value = 1 , message = "Age cannot be negative")
    @Max(120)
    private Integer age;

    private String address;

    @DBRef
    private Trip trips;

    @DBRef
    private Booking bookings;

    @DBRef
    private Bus bus;


    public User() {
    }

    public User(String id, String username, String password, String email, String roles, boolean enabled, String gender, Integer age, String address, Trip trips, Booking bookings, Bus bus) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles = roles;
        this.enabled = enabled;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.trips = trips;
        this.bookings = bookings;
        this.bus = bus;
    }

}