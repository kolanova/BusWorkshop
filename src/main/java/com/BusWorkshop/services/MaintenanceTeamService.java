package com.BusWorkshop.services;
import com.BusWorkshop.controller.request.MaintenanceRQ;
import com.BusWorkshop.exceptions.ResourceNotFound;
import com.BusWorkshop.model.BusType;
import com.BusWorkshop.model.MaintenanceTeam;
import com.BusWorkshop.repository.MaintenanceTeamRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceTeamService {

    MaintenanceTeamRepository maintenanceTeamRepository;

    public MaintenanceTeamService(MaintenanceTeamRepository maintenanceTeamRepository) {
        this.maintenanceTeamRepository = maintenanceTeamRepository;
    }
    public List<MaintenanceTeam> findAll() {
        return maintenanceTeamRepository.findAll();
    }
    public Optional<MaintenanceTeam>  findById(String id) {
        return maintenanceTeamRepository.findById(id);
    }

    public MaintenanceTeam updateMaintenanceTeamById(String maintenanceTeamId, MaintenanceRQ maintenanceRQ) {
        String name = maintenanceRQ.getName();
        boolean availability = maintenanceRQ.isAvailability();
        if(!maintenanceTeamRepository.existsById(maintenanceTeamId)){
            throw new ResourceNotFound("You need to add an existing Maintenance Team");
        }
        MaintenanceTeam maintenanceTeamToBeUpdated = maintenanceTeamRepository.findById(maintenanceTeamId).get();
        maintenanceTeamToBeUpdated.setAvailability(availability);
        maintenanceTeamToBeUpdated.setName(name);
        return maintenanceTeamRepository.save(maintenanceTeamToBeUpdated);
    }

    public MaintenanceTeam updateMaintenanceTeamByName(String maintenanceTeamName, MaintenanceRQ maintenanceRQ) {
        String name = maintenanceTeamName;
        boolean availability = maintenanceRQ.isAvailability();
        if(!maintenanceTeamRepository.findMaintenanceTeamByName(maintenanceTeamName).isPresent()){
            throw new ResourceNotFound("You need to add an existing Maintenance Team");
        }
        MaintenanceTeam maintenanceTeamToBeUpdated = maintenanceTeamRepository.findMaintenanceTeamByName(maintenanceTeamName).get();
        maintenanceTeamToBeUpdated.setAvailability(availability);
        maintenanceTeamToBeUpdated.setName(name);
        return maintenanceTeamRepository.save(maintenanceTeamToBeUpdated);
    }
}
