package com.BusWorkshop.controller;
import com.BusWorkshop.controller.request.BusRQ;
import com.BusWorkshop.model.Bus;
import com.BusWorkshop.model.MaintenanceTeam;
import com.BusWorkshop.services.BusService;
import com.BusWorkshop.services.MaintenanceTeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class BusController {

    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @PostMapping(value ="/bus", consumes = "application/json", produces = "application/json")
    public ResponseEntity createBus(@RequestBody BusRQ busRQ){
        String busName = busService.create(busRQ).getName();
        return ResponseEntity.created(URI.create("/bus" + busName)).body("Bus was added to our DB");
    }
    // Get all buses on database
    @GetMapping("/buses")
    public List<Bus> getBuses() {
        return busService.findAll();}

    // Get all buses on database by ID
    @GetMapping("/buses/{id}")
    public Optional<Bus> getBusesId(String id) {
        return busService.findById(id);}
    // Get all buses on database by Name
    @GetMapping("/buses/{name}")
    public Optional<Bus> getBusesName(String name) {
        return busService.findByName(name);}

    //Update bus byId
    @PutMapping(value ="/bus/id", consumes = "application/json", produces = "application/json")
    public ResponseEntity updateBusByID(@RequestParam String busId, @RequestBody BusRQ busRQ){
        busService.updateBusById(busId, busRQ);
        return ResponseEntity.created(URI.create("/bus/" + busId)).body("Bus Updated");
    }

    //Update bus byName
    @PutMapping(value ="/bus/name", consumes = "application/json", produces = "application/json")
    public ResponseEntity updateBusByName(@RequestParam String busName, @RequestBody BusRQ busRQ){
        busService.updateBusByName(busName, busRQ);
        return ResponseEntity.created(URI.create("/bus/" + busName)).body("Bus Updated");
    }

    //Delete bus by ID
    @DeleteMapping(path = "delete-bus/{id}")
    public ResponseEntity deleteBus(@PathVariable(value = "id") String busId) {
        busService.deleteById(busId);
        return ResponseEntity.created(URI.create("/bus")).body("Bus was created");
    }

}
