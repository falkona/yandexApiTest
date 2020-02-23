package ru.weather.models;

import lombok.Getter;

import java.time.LocalDateTime;

public class ExpectedResult {

    @Getter private String latitude;
    @Getter private String longitude;
    @Getter private String limit;
    @Getter private String hours;
    @Getter private String timeZoneName;
    @Getter private String abbr;
    @Getter private int offset;
    @Getter private boolean dst;

    public ExpectedResult(String timeZoneName) {
        switch (timeZoneName) {
            case ("Europe/Moscow"):
                this.latitude = "55.621045";
                this.longitude = "37.701031";
                this.limit = "2";
                this.hours = "false";
                this.timeZoneName = timeZoneName;
                this.abbr = "MSK";
                this.offset = 10800;
                this.dst = false;
                break;
        }
    }

    public String getExpectedUrlForWeather() {
        return String.format("https://yandex.ru/pogoda/?lat=%s&lon=%s", latitude, longitude);
    }

    public static String getCurrentSeason() {
        LocalDateTime now = LocalDateTime.now();

        int monthValue = now.getMonthValue();
        String season = "";
        switch (monthValue) {
            case 1:
            case 2:
            case 12:
                season = "winter";
                break;
            case 3:
            case 4:
            case 5:
                season = "spring";
                break;
            case 6:
            case 7:
            case 8:
                season = "summer";
                break;
            case 9:
            case 10:
            case 11:
                season = "autumn";
                break;
        }
        return season;
    }
}
