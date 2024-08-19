package com.example.CabXpress.dto.response;

import com.example.CabXpress.Enum.BookingStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class BookingResponse {

    String bookingId;
    String pickUp;
    String destination;
    Date bookedAt;  // both date and time - Util
    Date updatedAt;
    double totalFare;
    double totalDistance;
    BookingStatus status;

    CustomerResponse customer;

    CabResponse cab;

    DriverResponse driver;
}
