package ru.weather.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * ��������������� ����� ��� ������ � �������
 */

public class DataHelper {

    /**
     * ����� ��������� HashMap �� �������� �����
     * @param keys - ������ �����, ����� ��� HashMap
     * @param values - ������ �����, �������� ��� HashMap
     * @return ��������� ���������� HashMap
     */
    public static Map<String, String> putParamsToMap(String[] keys, String[] values) {
        Map<String, String> params = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            params.put(keys[i], values[i]);
        }
        return params;
    }

    /**
     * ������� ��� ��������� �������� ���� ���� �� ����
     * @param moonCode - ����� ����� �� 0 �� 12
     * @return ���������� �������� ����, ��������������� ��������� ����
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
