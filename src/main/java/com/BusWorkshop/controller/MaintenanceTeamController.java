package com.BusWorkshop.controller;
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

    private final MaintenanceTeamService maintenanceTeamService;

    public MaintenanceTeamController(MaintenanceTeamService maintenanceTeamService) {
        this.maintenanceTeamService = maintenanceTeamService;
    }


    @PostMapping(value ="/maintenance-teams", consumes = "application/json", produces = "application/json")
    public ResponseEntity createMaintenanceTeam (@RequestBody MaintenanceRQ maintenanceRQ){
        String maintenanceTeamsName = maintenanceTeamService.create(maintenanceRQ).getName();
        return ResponseEntity.created(URI.create("/maintenance-teams" + maintenanceTeamsName)).body("Team was added to our DB");
    }

    // Get all maintenance teams on database
    @GetMapping("/maintenance-teams")
    public List<MaintenanceTeam> getMaintenanceTeam() {
        return maintenanceTeamService.findAll();
    }

    // Get all maintenance teams on database by ID
    @GetMapping("/maintenance-teams/{id}")
    public Optional<MaintenanceTeam> getMaintenanceTeamId(String id) {
        return maintenanceTeamService.findById(id);
    }

    @GetMapping("/maintenance-teams/{name}")
    public Optional<MaintenanceTeam> getMaintenanceTeamName(String name) {
        return maintenanceTeamService.findByName(name);
    }

    @PutMapping(value ="/maintenance-team/id", consumes = "application/json", produces = "application/json")
    public ResponseEntity updateMaintenanceTeamById(@RequestParam String maintenanceTeamId, @RequestBody MaintenanceRQ maintenanceRQ){
        maintenanceTeamService.updateMaintenanceTeamById(maintenanceTeamId, maintenanceRQ);
        return ResponseEntity.created(URI.create("/maintenanceTeam/" + maintenanceTeamId)).body("Maintenance Team Updated");
    }

    @PutMapping(value ="/maintenance-team/name", consumes = "application/json", produces = "application/json")
    public ResponseEntity updateMaintenanceTeamByName(@RequestParam String maintenanceTeamName, @RequestBody MaintenanceRQ maintenanceRQ){
        maintenanceTeamService.updateMaintenanceTeamByName(maintenanceTeamName, maintenanceRQ);
        return ResponseEntity.created(URI.create("/maintenanceTeam/" + maintenanceTeamName)).body("Maintenance Team Updated");
    }

    @DeleteMapping(path = "delete-maintenance-teams/{id}")
    public ResponseEntity deleteMaintenanceTeams(@PathVariable(value = "id") String maintenanceteamId) {
        maintenanceTeamService.deleteById(maintenanceteamId);
        return ResponseEntity.created(URI.create("/maintenanceteams")).body("Team was added to our DB");
    }

    @PutMapping(value ="/maintenance-team/sick", consumes = "application/json", produces = "application/json")
    public ResponseEntity makeMaintenanceTeamSick(@RequestParam String maintenanceTeamName){
        maintenanceTeamService.makeMaintenanceTeamSick(maintenanceTeamName);
        return ResponseEntity.created(URI.create("/maintenanceTeam/" + maintenanceTeamName)).body("Maintenance Is Now Sick");
    }
}
