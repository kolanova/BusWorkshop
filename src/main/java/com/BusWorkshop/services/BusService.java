package com.BusWorkshop.services;
import com.BusWorkshop.controller.request.BusRQ;
import com.BusWorkshop.exceptions.DuplicatedNameBusException;
import com.BusWorkshop.exceptions.ResourceNotFound;
import com.BusWorkshop.model.Bus;
import com.BusWorkshop.model.BusType;
import com.BusWorkshop.repository.BusRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BusService {

    BusRepository busRepository;

    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public List<Bus> findAll() {
        return busRepository.findAll();
    }
    public Optional<Bus> findById(String id) {
        return busRepository.findById(id);
    }

    public Bus updateBusById(String busId, BusRQ busRQ) {
        String name = busRQ.getName();
        LocalDateTime maintenanceDay = busRQ.getMaintenanceDay();
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
        LocalDateTime maintenanceDay = busRQ.getMaintenanceDay();
        BusType busType = busRQ.getBusType();
        //Add exception if bus don't exists
        if(!busRepository.findBusByName(name).isPresent()){
            throw new ResourceNotFound("You need to add an existing Bus");
        }
        //add exception to check if name already exists
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
        return busRepository.findBusByName(name);
    }


}
