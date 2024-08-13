package com.example.CabXpress.model;

import com.example.CabXpress.Enum.BookingStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String bookingId; // UUID

    String pickUp;

    String destination;

    @CreationTimestamp
    Date bookedAt;  // both date and time - Util

    @UpdateTimestamp
    Date updatedAt;

    double totalFare;

    double totalDistance;

    BookingStatus status;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Customer customer;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Driver driver;
}
