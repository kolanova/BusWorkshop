package com.BusWorkshop.services;
import com.BusWorkshop.controller.repository.BusRepository;
import org.springframework.stereotype.Service;

@Service
public class BusService {

    BusRepository busRepository;

    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }
}
