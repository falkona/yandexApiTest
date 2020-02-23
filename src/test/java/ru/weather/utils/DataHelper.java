package ru.weather.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * ¬спомогательный класс дл€ работы с данными
 */

public class DataHelper {

    /**
     * ћетод формирует HashMap из массивов строк
     * @param keys - массив строк, ключи дл€ HashMap
     * @param values - массив строк, значени€ дл€ HashMap
     * @return взвращает полученный HashMap
     */
    public static Map<String, String> putParamsToMap(String[] keys, String[] values) {
        Map<String, String> params = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            params.put(keys[i], values[i]);
        }
        return params;
    }

    /**
     * ‘ункци€ дл€ получени€ названи€ фазы Ћуны по коду
     * @param moonCode - целое число от 0 до 12
     * @return возвращает название фазы, соответствующее заданному коду
     */
    public static String getMoonText(int moonCode) {
        String moonText = "";
        switch (moonCode) {
            case 0:
                moonText = "full-moon";
                break;
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                moonText = "decreasing-moon";
                break;
            case 4:
                moonText = "last-quarter ";
                break;
            case 8:
                moonText = "new-moon";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
                moonText = "growing-moon";
                break;
            case 12:
                moonText = "first-quarter";
                break;
        }
        return moonText;
    }
}
