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
    MaintenanceTeamService maintenanceTeamService;



    public BusController(BusService busService) {
        this.busService = busService;
    }
    public BusController(MaintenanceTeamService maintenanceTeamService) {this.maintenanceTeamService = maintenanceTeamService;}

    // Get all buses on database
    @GetMapping("/buses")
    public List<Bus> getBuses() {
        return busService.findAll();}
    // Get all maintenance teams on database
    @GetMapping("/maintenanceteams")
    public List<MaintenanceTeam> getMaintenanceTeam() {
        return maintenanceTeamService.findAll();}
    // Get all buses on database by ID
    @GetMapping("/buses/{id}")
    public Optional<Bus> getBusesId(String id) {
        return busService.findById(id);}
    // Get all maintenance teams on database by ID
    @GetMapping("/maintenanceteams/{id}")
    public Optional<MaintenanceTeam> getMaintenanceTeamId(String id) {
        return maintenanceTeamService.findById(id);
    }

}
