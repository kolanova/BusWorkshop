package com.BusWorkshop.repository;
import com.BusWorkshop.model.Bus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface BusRepository extends MongoRepository<Bus, String> {
    Optional<Bus> findBusByName(String Name);
}
