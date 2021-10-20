package com.BusWorkshop.controller;
import com.BusWorkshop.controller.request.BusRQ;
import com.BusWorkshop.model.Bus;
import com.BusWorkshop.services.BusService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
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
        return busService.findAll();
    }

    // Get all buses on database by ID
    @GetMapping("/buses/{id}")
    public Optional<Bus> getBusesId(String id) {
        return busService.findById(id);
    }

    // Get all buses on database by Name
    @GetMapping("/buses/{name}")
    public Optional<Bus> getBusesName(String name) {
        return busService.findByName(name);
    }

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

    @PutMapping(value ="/bus/repair", consumes = "application/json", produces = "application/json")
    public ResponseEntity upadateRepair(@RequestParam String busName, @RequestParam String maintenanceTeamName, @Valid int scheduleYear2021to3000, @Valid int scheduleMonth1to12, @Valid int scheduleDay1to31, @Valid int scheduleHour0to23){
        LocalDateTime newTime = LocalDateTime.of(scheduleYear2021to3000, scheduleMonth1to12, scheduleDay1to31, scheduleHour0to23,00,00);
        busService.updateRepair(busName, maintenanceTeamName, newTime);
        return ResponseEntity.created(URI.create("/bus/repair" + busName)).body("Repair schedule");
    }

    //Delete bus by ID
    @DeleteMapping(path = "/delete-bus/{id}")
    public ResponseEntity deleteBus(@PathVariable(value = "id") String busId) {
        busService.deleteById(busId);
        return ResponseEntity.created(URI.create("/bus")).body("Bus was deleted");
    }
}
