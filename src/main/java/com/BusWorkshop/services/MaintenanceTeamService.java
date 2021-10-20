package com.BusWorkshop.services;
import com.BusWorkshop.controller.request.MaintenanceRQ;
import com.BusWorkshop.exceptions.ResourceNotFound;
import com.BusWorkshop.model.MaintenanceTeam;
import com.BusWorkshop.model.MaintenanceType;
import com.BusWorkshop.repository.MaintenanceTeamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceTeamService {

    private final MaintenanceTeamRepository maintenanceTeamRepository;

    public MaintenanceTeamService(MaintenanceTeamRepository maintenanceTeamRepository) {
        this.maintenanceTeamRepository = maintenanceTeamRepository;
    }
    public List<MaintenanceTeam> findAll() {
        return maintenanceTeamRepository.findAll();
    }
    public Optional<MaintenanceTeam>  findById(String id) {
        return maintenanceTeamRepository.findById(id);
    }

    public MaintenanceTeam finById(String id) {
        return maintenanceTeamRepository.findById(id).orElseThrow(() -> new ResourceNotFound("This team memer doesn't exist"));
    } //new

    public void deleteById(String id) {
        maintenanceTeamRepository.deleteById(id);
    } // delete

    public MaintenanceTeam create(MaintenanceRQ maintenanceRQ) {

        String mainteanseTeamName = maintenanceRQ.getName();
        MaintenanceTeam newMaintenanceTeam = MaintenanceTeam
                .builder()
                .name(mainteanseTeamName)
                .build();
        return maintenanceTeamRepository.save(newMaintenanceTeam);
    }
}
