package com.BusWorkshop.services;
import com.BusWorkshop.controller.repository.MaintenanceTeamRepository;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceTeamService {

    MaintenanceTeamRepository maintenanceTeamRepository;

    public MaintenanceTeamService(MaintenanceTeamRepository maintenanceTeamRepository) {
        this.maintenanceTeamRepository = maintenanceTeamRepository;
    }
}
