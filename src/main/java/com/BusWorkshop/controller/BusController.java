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
    // Get all buses on database by Name
    @GetMapping("/buses/{name}")
    public Optional<Bus> getBusesName(String name) {
        return busService.findByName(name);}

    //Update bus byId
    @PutMapping(value ="/bus/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity updateBusByID(@PathVariable(value = "id") String busId, @RequestBody BusRQ busRQ){
        busService.updateBusById(busId, busRQ);
        return ResponseEntity.created(URI.create("/bus/" + busId)).body("Bus Updated");
    }

    //Update bus byName
    @PutMapping(value ="/bus/{name}", consumes = "application/json", produces = "application/json")
    public ResponseEntity updateBusByName(@PathVariable(value = "name") String busName, @RequestBody BusRQ busRQ){
        busService.updateBusByName(busName, busRQ);
        return ResponseEntity.created(URI.create("/bus/" + busName)).body("Bus Updated");
    }
}
