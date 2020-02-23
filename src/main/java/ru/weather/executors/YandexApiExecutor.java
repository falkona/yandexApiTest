package ru.weather.executors;

import com.fasterxml.jackson.databind.ObjectMapper;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.configs.Config;
import ru.weather.interfaces.WeatherApiService;
import ru.weather.models.WeatherResponse;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Класс для выполнения API-запросов Яндекс.Погоды.
 */
public class YandexApiExecutor {

    private WeatherApiService weatherApiService;
    private String yandexApiKey;

    /**
     * Конструктор
     * Устанавливается yandexApiKey (токен доступа) и создается сервис weatherApiService для вызова методов.
     */
    public YandexApiExecutor() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Config config = objectMapper.readValue(new File("src/test/resources/config.json"), Config.class);
        yandexApiKey = config.getYandexApiKey();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(config.getWeatherBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        weatherApiService = retrofit.create(WeatherApiService.class);
    }

    /**
     * @param queryOptions - query-параметры запроса в виде пары "ключ-значение". Ключ - название параметры, значение - значение параметра.
     * @return возвращает объект WeatherResponse (десериализованный json)
     * @throws IOException
     */
    public WeatherResponse executeWeather(Map<String, String> queryOptions) throws IOException {
        return weatherApiService.getWeatherForecast(yandexApiKey, queryOptions).execute().body();
    }
}
