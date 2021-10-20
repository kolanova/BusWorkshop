package com.BusWorkshop.services;
import com.BusWorkshop.controller.request.BusRQ;
import com.BusWorkshop.exceptions.DuplicatedNameBusException;
import com.BusWorkshop.exceptions.ResourceNotFound;
import com.BusWorkshop.exceptions.TeamNotAvailable;
import com.BusWorkshop.model.Bus;
import com.BusWorkshop.model.BusType;
import com.BusWorkshop.model.MaintenanceTeam;
import com.BusWorkshop.repository.BusRepository;
import com.BusWorkshop.repository.MaintenanceTeamRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BusService {

    private final BusRepository busRepository;
    private final MaintenanceTeamRepository maintenanceTeamRepository;

    public BusService(BusRepository busRepository, MaintenanceTeamRepository maintenanceTeamRepository) {
        this.busRepository = busRepository;
        this.maintenanceTeamRepository = maintenanceTeamRepository;
    }


    public List<Bus> findAll() {
        return busRepository.findAll();
    }

    public Optional<Bus> findById(String id) {
        if(!busRepository.existsById(id)){
            throw new ResourceNotFound("You need to add an existing Bus");
        }
        return busRepository.findById(id);
    }

    public Bus create(BusRQ busRQ) {
        BusType busType = busRQ.getBusType();
        String busName = busRQ.getName();
        if(busRepository.findBusByName(busName).isPresent()){
            throw new DuplicatedNameBusException("Name already chosen! Try a different one.");
        }
        int year = busRQ.getYear();
        int month = busRQ.getMonth();
        int day = busRQ.getDay();
        int hour = busRQ.getHour();
        LocalDateTime maintenanceDay = LocalDateTime.of(year, month, day, hour,00,00);
        Bus newBus = Bus
                .builder()
                .name(busName)
                .busType(busType)
                .maintenanceDay(maintenanceDay)
                .build();
        return busRepository.save(newBus);
    }

    public Bus updateBusById(String busId, BusRQ busRQ) {
        String name = busRQ.getName();
        int year = busRQ.getYear();
        int month = busRQ.getMonth();
        int day = busRQ.getDay();
        int hour = busRQ.getHour();
        LocalDateTime maintenanceDay = LocalDateTime.of(year, month, day, hour,00,00);
        BusType busType = busRQ.getBusType();
        //Add exception if bus don't exists
        if(!busRepository.existsById(busId)){
            throw new ResourceNotFound("You need to add an existing Bus");
        }
        //add exception to check if name already exists
        if(busRepository.findBusByName(name).isPresent()){
            throw new DuplicatedNameBusException("Name already chosen! Try a different one.");
        }
        Bus busToBeUpdated = busRepository.findById(busId).get();
        busToBeUpdated.setBusType(busType);
        busToBeUpdated.setName(name);
        busToBeUpdated.setMaintenanceDay(maintenanceDay);
        return busRepository.save(busToBeUpdated);
    }

    public Bus updateBusByName(String busName, BusRQ busRQ) {
        String name = busName;
        int year = busRQ.getYear();
        int month = busRQ.getMonth();
        int day = busRQ.getDay();
        int hour = busRQ.getHour();
        LocalDateTime maintenanceDay = LocalDateTime.of(year, month, day, hour,00,00);
        BusType busType = busRQ.getBusType();
        if(!busRepository.findBusByName(name).isPresent()){
            throw new ResourceNotFound("You need to add an existing Bus");
        }
        if(busRepository.findBusByName(name).isPresent()){
            throw new DuplicatedNameBusException("Name already chosen! Try a different one.");
        }
        Bus busToBeUpdated = busRepository.findBusByName(name).get();
        busToBeUpdated.setBusType(busType);
        busToBeUpdated.setName(name);
        busToBeUpdated.setMaintenanceDay(maintenanceDay);
        return busRepository.save(busToBeUpdated);
    }

    public Optional<Bus> findByName(String name) {
        if(!busRepository.findBusByName(name).isPresent()){
            throw new ResourceNotFound("You need to add an existing Bus");
        }
        return busRepository.findBusByName(name);
    }

    public void deleteById(String id) {
        busRepository.deleteById(id);
    } // delete

    public Bus updateRepair(String busName, String maintenanceTeamName, LocalDateTime newtime) {
        if(!maintenanceTeamRepository.findMaintenanceTeamByName(maintenanceTeamName).isPresent()){
            throw new ResourceNotFound("You need to add an existing Maintenance Team");
        }
        if(!busRepository.findBusByName(busName).isPresent()){
            throw new ResourceNotFound("You need to add an existing Bus");
        }
        MaintenanceTeam maintenanceTeam = maintenanceTeamRepository.findMaintenanceTeamByName(maintenanceTeamName).get();
        if(!maintenanceTeam.isAvailability()){
            throw new TeamNotAvailable("Team is Not available come back later!");
        }
        Bus busToBeRepair = busRepository.findBusByName(busName).get();
        busToBeRepair.setMaintenanceDay(newtime);
        return busRepository.save(busToBeRepair);
    }
}
