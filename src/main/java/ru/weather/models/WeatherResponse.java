package ru.weather.models;

import lombok.Getter;

import java.util.List;

public class WeatherResponse {

    @Getter protected long now;
    @Getter protected String now_dt;
    @Getter protected Info info;
    @Getter protected FactWeatherInfo fact;
    @Getter protected List<Forecast> forecasts;
}
