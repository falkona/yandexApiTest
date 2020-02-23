package ru.configs;

import lombok.Getter;
import lombok.Setter;

public class Config {
    @Getter @Setter private String yandexApiKey;
    @Getter @Setter private String weatherBaseUrl;
}
