package com.example.CabXpress.dto.request;

import com.example.CabXpress.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.logging.Level;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRequest {

    String name;

    int age;

    String emailId;

    Gender gender;
}
