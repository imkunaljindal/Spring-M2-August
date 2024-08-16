package com.example.CabXpress.service;

import com.example.CabXpress.dto.request.CouponRequest;
import com.example.CabXpress.model.Coupon;
import com.example.CabXpress.repository.CouponRepository;
import com.example.CabXpress.transformer.CouponTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponService {

    @Autowired
    CouponRepository couponRepository;

    public String addCoupon(CouponRequest couponRequest) {
        Coupon coupon = CouponTransformer.couponRequestToCoupon(couponRequest);
        couponRepository.save(coupon);
        return "Coupon added successfully";
    }
}
