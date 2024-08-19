package com.example.CabXpress.transformer;

import com.example.CabXpress.Enum.BookingStatus;
import com.example.CabXpress.dto.request.BookingRequest;
import com.example.CabXpress.dto.response.BookingResponse;
import com.example.CabXpress.model.Booking;
import com.example.CabXpress.model.Cab;

import java.util.UUID;

public class BookingTransformer {

    public static Booking bookingRequestToBooking(BookingRequest bookingRequest,
                                           Cab cab) {
        return Booking.builder()
                .bookingId(String.valueOf(UUID.randomUUID()))
                .pickUp(bookingRequest.getPickUp())
                .destination(bookingRequest.getDestination())
                .totalFare(cab.getFarePerKm()*bookingRequest.getTotalDistance())
                .totalDistance(bookingRequest.getTotalDistance())
                .status(BookingStatus.BOOKED)
                .build();
    }

    public static BookingResponse bookingToBookingResponse(Booking booking) {
        return BookingResponse.builder()
                .bookingId(booking.getBookingId())
                .pickUp(booking.getPickUp())
                .destination(booking.getDestination())
                .bookedAt(booking.getBookedAt())
                .updatedAt(booking.getUpdatedAt())
                .totalDistance(booking.getTotalDistance())
                .totalFare(booking.getTotalFare())
                .status(booking.getStatus())
                .customer(CustomerTransformer.customerToCustomerResponse(booking.getCustomer()))
                .cab(CabTransformer.cabToCabResponse(booking.getDriver().getCab()))
                .driver(DriverTransformer.driverToDriverResponse(booking.getDriver()))
                .build();
    }
}
