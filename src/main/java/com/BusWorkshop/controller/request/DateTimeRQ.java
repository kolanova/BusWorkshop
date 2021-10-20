package com.BusWorkshop.controller.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class DateTimeRQ {
    private int year;
    private int month;
    private int day;
    private int hour;
}
