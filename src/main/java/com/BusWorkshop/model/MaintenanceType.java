package com.BusWorkshop.model;

public enum MaintenanceType {
    CHANGE_TIRE(5),
    OIL_CHANGE(1),
    ENGINE_REBUILD(4),
    FIX_DOOR(6);
    private int hour;

    MaintenanceType(int hour) {
        this.hour = hour;
    }


    public int getResponse() {
        return hour;
    }
}
