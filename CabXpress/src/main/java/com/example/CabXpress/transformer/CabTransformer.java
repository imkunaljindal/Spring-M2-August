package com.example.CabXpress.transformer;

import com.example.CabXpress.dto.response.CabResponse;
import com.example.CabXpress.model.Cab;

public class CabTransformer {

    public static CabResponse cabToCabResponse(Cab cab) {
        return CabResponse.builder()
                .cabNo(cab.getCabNo())
                .cabModel(cab.getCabModel())
                .cabType(cab.getCabType())
                .farePerKm(cab.getFarePerKm())
                .build();
    }
}
