package com.moshnyk.testtaskone;

import org.apache.log4j.Logger;

import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloWorld {

    private static final String TIMES_OF_DAY_MORNING = "Morning";
    private static final String TIMES_OF_DAY_DAY = "Day";
    private static final String TIMES_OF_DAY_EVENING = "Evening";
    private static final String TIMES_OF_DAY_NIGHT = "Night";

    private static final Logger log = Logger.getLogger(HelloWorld.class);

    private static int getCurrentTimeInHours() {
        LocalTime localTime = LocalTime.now();
        return localTime.getHour();
    }

    public static String getCurrentTimesOfDay(int hours) {
        if (hours >= 6 && hours < 9) {
            return TIMES_OF_DAY_MORNING;
        }
        if (hours >= 9 && hours < 19) {
            return TIMES_OF_DAY_DAY;
        }
        if (hours >= 19 && hours < 23) {
            return TIMES_OF_DAY_EVENING;
        }
        if (hours == 23 || hours < 6 && hours >= 0) {
            return TIMES_OF_DAY_NIGHT;
        } else {
            log.error("Invalid time of hours!");
            return "Invalid date!";
        }
    }

    public static String getGreeting(String timeOfDAy, Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        ResourceBundle bundle = ResourceBundle.getBundle("TimeOfDayBundle", locale);
        String result;
        switch (timeOfDAy) {
            case TIMES_OF_DAY_MORNING:
                result = bundle.getString("morning");
                break;
            case TIMES_OF_DAY_DAY:
                result = bundle.getString("day");
                break;
            case TIMES_OF_DAY_EVENING:
                result = bundle.getString("evening");
                break;
            case TIMES_OF_DAY_NIGHT:
                result = bundle.getString("night");
                break;
            default:
                return "Invalid date!";
        }
        return new String(result.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8); //for russian text
    }

    public static void main(String[] args) {
        int hours = getCurrentTimeInHours();
        String timeOfDay = getCurrentTimesOfDay(hours);
        String greeting = getGreeting(timeOfDay, null);

        System.out.println(greeting);
        log.info("Result program: " + greeting);
    }
}
