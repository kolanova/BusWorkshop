package com.BusWorkshop.repository;
import com.BusWorkshop.model.Bus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
// this interface is responsible for a data access layer
public interface BusRepository
        extends MongoRepository<Bus, String> {
/*    @Override
    Optional<Bus> findById(String s);*/
}
