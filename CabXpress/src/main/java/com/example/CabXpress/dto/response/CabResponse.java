package com.example.CabXpress.dto.response;


import com.example.CabXpress.Enum.CabType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CabResponse {
    String cabNo;

    String cabModel;

    CabType cabType;

    double farePerKm;
}
