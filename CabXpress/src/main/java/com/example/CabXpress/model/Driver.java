package com.example.CabXpress.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    long mobNo;

    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
    List<Booking> bookings = new ArrayList<>();

    @OneToOne(mappedBy = "driver",cascade = CascadeType.ALL)
    Cab cab;
}
