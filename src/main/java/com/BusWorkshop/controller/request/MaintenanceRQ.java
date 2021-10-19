package com.BusWorkshop.controller.request;
import com.BusWorkshop.model.BusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceRQ {
    private String name;
    private boolean availability;
    private BusType busType;
}
