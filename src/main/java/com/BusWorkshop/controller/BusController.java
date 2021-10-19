package com.BusWorkshop.controller;
import com.BusWorkshop.model.Bus;
import com.BusWorkshop.model.MaintenanceTeam;
import com.BusWorkshop.services.BusService;
import com.BusWorkshop.services.MaintenanceTeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BusController {

    BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    // Get all buses on database
    @GetMapping("/buses")
    public List<Bus> getBuses() {
        return busService.findAll();}

    // Get all buses on database by ID
    @GetMapping("/buses/{id}")
    public Optional<Bus> getBusesId(String id) {
        return busService.findById(id);}


}
