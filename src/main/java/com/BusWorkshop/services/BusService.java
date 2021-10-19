package com.BusWorkshop.services;
import com.BusWorkshop.model.Bus;
import com.BusWorkshop.repository.BusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusService {

    BusRepository busRepository;

    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public List<Bus> findAll() {
        return busRepository.findAll();
    }
    public Optional<Bus> findById(String id) {
        return busRepository.findById(id);
    }

}
