package ru.weather.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.weather.executors.YandexApiExecutor;
import ru.weather.models.ExpectedResult;
import ru.weather.models.Forecast;
import ru.weather.models.WeatherResponse;
import ru.weather.utils.DataHelper;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherApiTest {

    private ExpectedResult expectedResult;

    @ParameterizedTest
    @MethodSource("getTimeZones")
    @DisplayName("1. Широта соответствует заданной")
    public void shouldReturnCorrectLatitude(String timeZoneName) throws IOException {
        YandexApiExecutor executor = new YandexApiExecutor();
        expectedResult = new ExpectedResult(timeZoneName);
        Map<String, String> params = DataHelper.putParamsToMap(new String[]{"lat", "lon", "limit", "hours"},
                new String[]{expectedResult.getLatitude(), expectedResult.getLongitude(), expectedResult.getLimit(), expectedResult.getHours()});
        WeatherResponse weatherResponse = executor.executeWeather(params);

        assertEquals(expectedResult.getLatitude(), weatherResponse.getInfo().getLat().toString());
    }

    @ParameterizedTest
    @MethodSource("getTimeZones")
    @DisplayName("2. Долгота соответствует заданной")
    public void shouldReturnCorrectLongitude(String timeZoneName) throws IOException {
        YandexApiExecutor executor = new YandexApiExecutor();
        expectedResult = new ExpectedResult(timeZoneName);
        Map<String, String> params = DataHelper.putParamsToMap(new String[]{"lat", "lon", "limit", "hours"},
                new String[]{expectedResult.getLatitude(), expectedResult.getLongitude(), expectedResult.getLimit(), expectedResult.getHours()});
        WeatherResponse weatherResponse = executor.executeWeather(params);

        assertEquals(expectedResult.getLongitude(), weatherResponse.getInfo().getLon().toString());
    }

    @ParameterizedTest
    @MethodSource("getTimeZones")
    @DisplayName("3. Часовой пояс соответствует заданной")
    public void shouldReturnCorrectOffset(String timeZoneName) throws IOException {
        YandexApiExecutor executor = new YandexApiExecutor();
        expectedResult = new ExpectedResult(timeZoneName);
        Map<String, String> params = DataHelper.putParamsToMap(new String[]{"lat", "lon", "hours"},
                new String[]{expectedResult.getLatitude(), expectedResult.getLongitude(), expectedResult.getHours()});
        WeatherResponse weatherResponse = executor.executeWeather(params);

        assertEquals(expectedResult.getOffset(), weatherResponse.getInfo().getTzinfo().getOffset());
    }

    @ParameterizedTest
    @MethodSource("getTimeZones")
    @DisplayName("4. Название часового пояса соответствует заданному")
    public void shouldReturnCorrectTimezoneName(String timeZoneName) throws IOException {
        YandexApiExecutor executor = new YandexApiExecutor();
        expectedResult = new ExpectedResult(timeZoneName);
        Map<String, String> params = DataHelper.putParamsToMap(new String[]{"lat", "lon", "hours"},
                new String[]{expectedResult.getLatitude(), expectedResult.getLongitude(), expectedResult.getHours()});
        WeatherResponse weatherResponse = executor.executeWeather(params);

        assertEquals(timeZoneName, weatherResponse.getInfo().getTzinfo().getName());
    }

    @ParameterizedTest
    @MethodSource("getTimeZones")
    @DisplayName("5. Аббревиатура часовго пояса соответствует заданной")
    public void shouldReturnCorrectTimezoneAbbr(String timeZoneName) throws IOException {
        YandexApiExecutor executor = new YandexApiExecutor();
        expectedResult = new ExpectedResult(timeZoneName);
        Map<String, String> params = DataHelper.putParamsToMap(new String[]{"lat", "lon", "hours"},
                new String[]{expectedResult.getLatitude(), expectedResult.getLongitude(), expectedResult.getHours()});
        WeatherResponse weatherResponse = executor.executeWeather(params);

        assertEquals(expectedResult.getAbbr(), weatherResponse.getInfo().getTzinfo().getAbbr());
    }

    @ParameterizedTest
    @MethodSource("getTimeZones")
    @DisplayName("6. Признак летнего времени соответствует ожидаемому")
    public void shouldReturnCorrectTimezoneDst(String timeZoneName) throws IOException {
        YandexApiExecutor executor = new YandexApiExecutor();
        expectedResult = new ExpectedResult(timeZoneName);
        Map<String, String> params = DataHelper.putParamsToMap(new String[]{"lat", "lon", "hours"},
                new String[]{expectedResult.getLatitude(), expectedResult.getLongitude(), expectedResult.getHours()});
        WeatherResponse weatherResponse = executor.executeWeather(params);

        assertEquals(expectedResult.isDst(), weatherResponse.getInfo().getTzinfo().isDst());
    }

    @ParameterizedTest
    @MethodSource("getTimeZones")
    @DisplayName("7. Ссылка населенного пункта соответствует ожидаемой")
    public void shouldReturnCorrectUrl(String timeZoneName) throws IOException {
        YandexApiExecutor executor = new YandexApiExecutor();
        expectedResult = new ExpectedResult(timeZoneName);
        Map<String, String> params = DataHelper.putParamsToMap(new String[]{"lat", "lon", "hours"},
                new String[]{expectedResult.getLatitude(), expectedResult.getLongitude(), expectedResult.getHours()});
        WeatherResponse weatherResponse = executor.executeWeather(params);

        assertEquals(expectedResult.getExpectedUrlForWeather(), weatherResponse.getInfo().getUrl());
    }

    @ParameterizedTest
    @MethodSource("getTimeZones")
    @DisplayName("8. Длина прогноза соответствует ожидаемой")
    public void shouldReturnCorrectForecastLength(String timeZoneName) throws IOException {
        YandexApiExecutor executor = new YandexApiExecutor();
        expectedResult = new ExpectedResult(timeZoneName);
        Map<String, String> params = DataHelper.putParamsToMap(new String[]{"lat", "lon", "limit", "hours"},
                new String[]{expectedResult.getLatitude(), expectedResult.getLongitude(), expectedResult.getLimit(), expectedResult.getHours()});
        WeatherResponse weatherResponse = executor.executeWeather(params);

        assertEquals(Integer.parseInt(expectedResult.getLimit()), weatherResponse.getForecasts().size());
    }

    @ParameterizedTest
    @MethodSource("getTimeZones")
    @DisplayName("9. Время года соответствует ожидаемому")
    public void shouldReturnCorrectSeason(String timeZoneName) throws IOException, ParseException {
        YandexApiExecutor executor = new YandexApiExecutor();
        expectedResult = new ExpectedResult(timeZoneName);
        Map<String, String> params = DataHelper.putParamsToMap(new String[]{"lat", "lon", "hours"},
                new String[]{expectedResult.getLatitude(), expectedResult.getLongitude(), expectedResult.getHours()});
        WeatherResponse weatherResponse = executor.executeWeather(params);

        assertEquals(ExpectedResult.getCurrentSeason(), weatherResponse.getFact().getSeason());
    }

    @ParameterizedTest
    @MethodSource("getTimeZones")
    @DisplayName("10. Название фазы луны соответствует коду фазы")
    public void shouldReturnCorrectMoonPhase(String timeZoneName) throws IOException {
        YandexApiExecutor executor = new YandexApiExecutor();
        expectedResult = new ExpectedResult(timeZoneName);
        Map<String, String> params = DataHelper.putParamsToMap(new String[]{"lat", "lon", "hours"},
                new String[]{expectedResult.getLatitude(), expectedResult.getLongitude(), expectedResult.getHours()});
        WeatherResponse weatherResponse = executor.executeWeather(params);

        Forecast forecast = weatherResponse.getForecasts().get(1);
        int moonCode = forecast.getMoon_code();

        assertEquals(DataHelper.getMoonText(moonCode), forecast.getMoon_text());
    }

    /**
     * Функция получения тайм-зон для тестов
     * @return возвращает список необходимых тайм-зон
     */
    private static List<String> getTimeZones() {
        List<String> args = new ArrayList<>();
        args.add("Europe/Moscow"); // Москва, на 2 дня, без почасовой детализации
        return args;
    }



}
