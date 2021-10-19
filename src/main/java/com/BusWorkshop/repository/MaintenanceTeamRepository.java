package com.BusWorkshop.repository;
import com.BusWorkshop.model.Bus;
import com.BusWorkshop.model.MaintenanceTeam;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaintenanceTeamRepository extends MongoRepository<MaintenanceTeam, String> {
    Optional<MaintenanceTeam> findMaintenanceTeamByName(String Name);
}

