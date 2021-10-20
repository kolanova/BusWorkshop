package com.BusWorkshop.services;
import com.BusWorkshop.controller.request.MaintenanceRQ;
import com.BusWorkshop.exceptions.ResourceNotFound;
import com.BusWorkshop.exceptions.TeamNotAvailable;
import com.BusWorkshop.model.MaintenanceTeam;
import com.BusWorkshop.repository.MaintenanceTeamRepository;
import org.springframework.stereotype.Service;
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
        if(!maintenanceTeamRepository.existsById(id)){
            throw new ResourceNotFound("You need to add an existing Maintenance Team");
        }
        return maintenanceTeamRepository.findById(id);
    }

    public MaintenanceTeam create(MaintenanceRQ maintenanceRQ) {
        String mainteanseTeamName = maintenanceRQ.getName();
        MaintenanceTeam newMaintenanceTeam = MaintenanceTeam
                .builder()
                .name(mainteanseTeamName)
                .build();
        return maintenanceTeamRepository.save(newMaintenanceTeam);
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

    public Optional<MaintenanceTeam> findByName(String name) {
        if(!maintenanceTeamRepository.findMaintenanceTeamByName(name).isPresent()){
            throw new ResourceNotFound("You need to add an existing Maintenance Team");
        }
        return  maintenanceTeamRepository.findMaintenanceTeamByName(name);
    }

    public void deleteById(String id) {
        maintenanceTeamRepository.deleteById(id);
    } // delete

    public MaintenanceTeam makeMaintenanceTeamSick(String maintenanceTeamName) {
        String name = maintenanceTeamName;

        if(!maintenanceTeamRepository.findMaintenanceTeamByName(maintenanceTeamName).isPresent()){
            throw new ResourceNotFound("You need to add an existing Maintenance Team");
        }
        MaintenanceTeam maintenanceTeamToBeUpdated = maintenanceTeamRepository.findMaintenanceTeamByName(maintenanceTeamName).get();
        if(!maintenanceTeamToBeUpdated.isAvailability()){
            throw new TeamNotAvailable("Team is now occupied");
        }
        maintenanceTeamToBeUpdated.setAvailability(false);
        return maintenanceTeamRepository.save(maintenanceTeamToBeUpdated);
    }
}
