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
public class BusRQ {
    private String name;
    private BusType busType;
    private int year;
    private int month;
    private int day;
    private int hour;
}
