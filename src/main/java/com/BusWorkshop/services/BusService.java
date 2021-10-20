package com.BusWorkshop.services;
import com.BusWorkshop.controller.request.BusRQ;
import com.BusWorkshop.exceptions.ResourceNotFound;
import com.BusWorkshop.model.Bus;
import com.BusWorkshop.model.BusType;
import com.BusWorkshop.repository.BusRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BusService {

    private final BusRepository busRepository;

    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public List<Bus> findAll() {
        return busRepository.findAll();
    }
    public Optional<Bus> findById(String id) {
        return busRepository.findById(id);
    }

    public Bus finById(String id) {
        return busRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Bus doesn't exist in our DB"));
    } //new

    public void deleteById(String id) {
        busRepository.deleteById(id);
    } // delete

    public Bus create(BusRQ busRQ) {
        BusType busType = busRQ.getBusType();
        String busName = busRQ.getName();
        LocalDateTime maintenanceDay= busRQ.getMaintenanceDay();
        Bus newBus = Bus
                .builder()
                .name(busName)
                .busType(busType)
                .maintenanceDay(maintenanceDay)
                .build();
        return busRepository.save(newBus);
    }
/*    public Bus updateBus(String busId, BusRQ busRQ) {
        List<String> lisTypes = new ArrayList<String>();
        lisTypes.add(BusType.SIMPLE.toString());
        lisTypes.add(BusType.DOUBLE.toString());
        lisTypes.add(BusType.MINI.toString());
        if (!lisTypes.contains(busRQ.getBusType().toString()));{
            throw new ResourceNotFound("You can only add SIMPLE, DOUBLE and MINI busses from BusType list");
        }
        BusType busType = busRQ.getBusType();
        String busName = busRQ.getName();
        LocalDateTime maintenanceDay= busRQ.getMaintenanceDay();
        if (!busRepository.existsById(busId)){
            throw new ResourceNotFound("This bus doesn't exist in our DB");
        }
        Bus busToBeUpdated = busRepository.getById(busId);
        busToBeUpdated.setBusType(busType);
        busToBeUpdated.setName(busName);
        busToBeUpdated.setMaintenanceDay(Maintea);
        return busRepository.save(busToBeUpdated);

        }*/

}
