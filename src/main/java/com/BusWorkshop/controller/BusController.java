package com.BusWorkshop.controller;
import com.BusWorkshop.controller.request.BusRQ;
import com.BusWorkshop.model.Bus;
import com.BusWorkshop.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/workshop/bus")
// to make it looks more organized
public class BusController {

    private final BusService busService;
    public BusController(BusService busService) {
        this.busService = busService;
    }

    /* we implement the ability for our API to save busses from our client
     if name doesn't exist, we want to save our bus in our DB
     if name is taken we want to trow an exception*/
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

    @DeleteMapping(path = "delete-bus/{id}")
    public ResponseEntity deleteBus(@PathVariable(value = "id") String busId) {
        busService.deleteById(busId);
        return ResponseEntity.created(URI.create("/bus")).body("Bus was created");
    }

}
