package com.BusWorkshop.controller.request;
import com.BusWorkshop.model.BusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BusRQ {
    private String name;
    private LocalDateTime maintenanceDay;
    private BusType busType;
}
