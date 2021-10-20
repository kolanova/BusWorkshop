package com.BusWorkshop.repository;
import com.BusWorkshop.model.MaintenanceTeam;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
// this interface is responsible for a data access layer
public interface MaintenanceTeamRepository
        extends MongoRepository<MaintenanceTeam, String> {
}
