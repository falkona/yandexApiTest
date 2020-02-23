package ru.weather.models;

import lombok.Getter;

public class TzInfo {

    @Getter protected String name;
    @Getter protected String abbr;
    @Getter protected int offset;
    @Getter protected boolean dst;
}
