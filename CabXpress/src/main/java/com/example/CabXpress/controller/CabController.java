package com.example.CabXpress.controller;

import com.example.CabXpress.model.Cab;
import com.example.CabXpress.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cab")
public class CabController {

    @Autowired
    CabService cabService;

    @PostMapping
    public String addCab(@RequestBody Cab cab) {
        return cabService.addCab(cab);
    }
}
