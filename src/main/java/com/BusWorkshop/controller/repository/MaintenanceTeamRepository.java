package com.BusWorkshop.controller.repository;
import com.BusWorkshop.model.MaintenanceTeam;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceTeamRepository extends MongoRepository<MaintenanceTeam, String> {
}
