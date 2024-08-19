package com.example.CabXpress.service;

import com.example.CabXpress.dto.request.BookingRequest;
import com.example.CabXpress.dto.response.BookingResponse;
import com.example.CabXpress.dto.response.DriverResponse;
import com.example.CabXpress.exception.CabNotAvailableException;
import com.example.CabXpress.exception.CustomerNotFoundException;
import com.example.CabXpress.model.Booking;
import com.example.CabXpress.model.Cab;
import com.example.CabXpress.model.Customer;
import com.example.CabXpress.model.Driver;
import com.example.CabXpress.repository.BookingRepository;
import com.example.CabXpress.repository.CabRepository;
import com.example.CabXpress.repository.CustomerRepository;
import com.example.CabXpress.repository.DriverRepository;
import com.example.CabXpress.transformer.BookingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class BookingService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CabRepository cabRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    DriverRepository driverRepository;

    public BookingResponse bookCab(BookingRequest bookingRequest) {
        Customer customer = customerRepository.findByEmailId(bookingRequest.getCustomerEmail());
        if(ObjectUtils.isEmpty(customer)) {
            throw new CustomerNotFoundException("Invalid email address");
        }

        Cab cab = cabRepository.getRandomAvailableCab();
        if(ObjectUtils.isEmpty(cab)) {
            throw new CabNotAvailableException("It seems to be busier than usual");
        }

        Driver driver = cab.getDriver();
        Booking booking = BookingTransformer.bookingRequestToBooking(bookingRequest,cab);
        booking.setCustomer(customer);
        booking.setDriver(cab.getDriver());

        Booking savedBooking = bookingRepository.save(booking);

        customer.getBookings().add(savedBooking);
        driver.getBookings().add(savedBooking);
        cab.setAvailable(false);

        customerRepository.save(customer); // cust + booking
        driverRepository.save(driver); // driver + booking + cab

        return BookingTransformer.bookingToBookingResponse(savedBooking);
    }
}
