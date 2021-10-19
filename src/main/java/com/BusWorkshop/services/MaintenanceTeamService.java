package com.BusWorkshop.services;
import com.BusWorkshop.model.MaintenanceTeam;
import com.BusWorkshop.repository.MaintenanceTeamRepository;
import org.springframework.stereotype.Service;

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

}
