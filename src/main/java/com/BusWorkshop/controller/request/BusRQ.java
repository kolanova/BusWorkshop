package com.BusWorkshop.controller.request;
import com.BusWorkshop.model.BusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BusRQ {
    private String name;
    private BusType busType;
    @Min(2021)
    @Max(3000)
    private int scheduleYear2021to3000;
    @Min(1)
    @Max(12)
    private int scheduleMonth1to12;
    @Min(1)
    @Max(31)
    private int scheduleDay1to31;
    @Min(0)
    @Max(23)
    private int scheduleHour0to23;
}
