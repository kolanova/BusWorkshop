package com.BusWorkshop.controller;
import com.BusWorkshop.controller.request.BusRQ;
import com.BusWorkshop.controller.request.MaintenanceRQ;
import com.BusWorkshop.model.MaintenanceTeam;
import com.BusWorkshop.services.MaintenanceTeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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
    // Get all buses on database by Name
    @GetMapping("/maintenanceteams/{name}")
    public Optional<MaintenanceTeam> getMaintenanceTeamName(String name) {
        return maintenanceTeamService.findByName(name);}

    @PutMapping(value ="/maintenanceTeam/id", consumes = "application/json", produces = "application/json")
    public ResponseEntity updateMaintenanceTeamById(@RequestParam String maintenanceTeamId, @RequestBody MaintenanceRQ maintenanceRQ){
        maintenanceTeamService.updateMaintenanceTeamById(maintenanceTeamId, maintenanceRQ);
        return ResponseEntity.created(URI.create("/maintenanceTeam/" + maintenanceTeamId)).body("Maintenance Team Updated");
    }

    @PutMapping(value ="/maintenanceTeam/name", consumes = "application/json", produces = "application/json")
    public ResponseEntity updateMaintenanceTeamByName(@RequestParam String maintenanceTeamName, @RequestBody MaintenanceRQ maintenanceRQ){
        maintenanceTeamService.updateMaintenanceTeamByName(maintenanceTeamName, maintenanceRQ);
        return ResponseEntity.created(URI.create("/maintenanceTeam/" + maintenanceTeamName)).body("Maintenance Team Updated");
    }
}
