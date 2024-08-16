package com.example.CabXpress.controller;

import com.example.CabXpress.dto.request.CouponRequest;
import com.example.CabXpress.service.CouponService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/coupon")
public class CouponController {

    @Autowired
    CouponService couponService;

    @GetMapping
    public ResponseEntity addCoupon(@RequestBody CouponRequest couponRequest) {
        String response = couponService.addCoupon(couponRequest);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}
