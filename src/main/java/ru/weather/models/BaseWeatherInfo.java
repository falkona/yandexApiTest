package ru.weather.models;

public abstract class BaseWeatherInfo {
    protected int feels_like;
    protected String icon;
    protected String condition;
    protected double wind_speed;
    protected double wind_gust;
    protected String wind_dir;
    protected int pressure_mm;
    protected int pressure_pa;
    protected int humidity;
    protected int uv_index;
    protected int soil_temp;
    protected double soil_moisture;
    //protected String polar;
    //protected String daytime;
}
