package com.BusWorkshop.controller;
import com.BusWorkshop.services.MaintenanceTeamService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaintenanceTeamController {

    MaintenanceTeamService maintenanceTeamService;

    public MaintenanceTeamController(MaintenanceTeamService maintenanceTeamService) {
        this.maintenanceTeamService = maintenanceTeamService;
    }
}
