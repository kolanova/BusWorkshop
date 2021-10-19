package com.BusWorkshop.controller;
import com.BusWorkshop.model.MaintenanceTeam;
import com.BusWorkshop.services.MaintenanceTeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MaintenanceTeamController {

    MaintenanceTeamService maintenanceTeamService;

    public MaintenanceTeamController(MaintenanceTeamService maintenanceTeamService) {
        this.maintenanceTeamService = maintenanceTeamService;
    }

    // Get all maintenance teams on database
    @GetMapping("/maintenanceteams")
    public List<MaintenanceTeam> getMaintenanceTeam() {
        return maintenanceTeamService.findAll();}
    // Get all maintenance teams on database by ID
    @GetMapping("/maintenanceteams/{id}")
    public Optional<MaintenanceTeam> getMaintenanceTeamId(String id) {
        return maintenanceTeamService.findById(id);
    }
}
