package com.BusWorkshop.controller;
import com.BusWorkshop.services.BusService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusController {

    BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }
}
