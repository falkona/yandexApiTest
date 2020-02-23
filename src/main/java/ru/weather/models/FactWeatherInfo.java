package ru.weather.models;

import lombok.Getter;

import java.util.Map;

public class FactWeatherInfo extends BaseWeatherInfo {

    protected int temp;
    @Getter protected String season;
    protected long obs_time;
    protected Map<String, Double> accum_prec;
    protected String source;
    protected String polar;
    protected String daytime;
}
