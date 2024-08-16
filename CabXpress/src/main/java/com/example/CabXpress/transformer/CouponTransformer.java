package com.example.CabXpress.transformer;

import com.example.CabXpress.dto.request.CouponRequest;
import com.example.CabXpress.model.Coupon;

public class CouponTransformer {

    public static Coupon couponRequestToCoupon(CouponRequest couponRequest) {
        return Coupon.builder()
                .couponCode(couponRequest.getCouponCode())
                .percentageDiscount(couponRequest.getPercentageDiscount())
                .build();
    }
}
