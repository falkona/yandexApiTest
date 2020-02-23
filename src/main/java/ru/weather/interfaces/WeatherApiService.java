package ru.weather.interfaces;

import retrofit2.Call;
import retrofit2.http.*;
import ru.weather.models.WeatherResponse;

import java.util.Map;

public interface WeatherApiService {

    @GET("v1/forecast")
    Call<WeatherResponse> getWeatherForecast(@Header("X-Yandex-API-Key") String yandexApiKey,
                                             @QueryMap Map<String, String> options);
}
