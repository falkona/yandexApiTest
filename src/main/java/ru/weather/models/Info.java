package ru.weather.models;

import lombok.Getter;

public class Info { // Объект информации о населенном пункте

    protected boolean f;
    protected boolean n;
    protected boolean nr;
    protected boolean ns;
    protected boolean nsr;
    protected boolean p;
    @Getter protected Double lat;
    @Getter protected Double lon;
    @Getter protected TzInfo tzinfo;
    protected double def_pressure_mm;
    protected double def_pressure_pa;
    protected boolean _h;
    @Getter protected String url;
}
