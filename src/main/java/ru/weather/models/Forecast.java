package ru.weather.models;

import lombok.Getter;

public class Forecast {

    protected String date;
    protected long date_ts;
    protected int week;
    protected String sunrise;
    protected String sunset;
    protected String rise_begin;
    protected String set_end;
    @Getter protected int moon_code;
    @Getter protected String moon_text;
    protected Parts parts;
}
