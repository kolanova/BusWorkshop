package com.BusWorkshop.controller.request;
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

}
