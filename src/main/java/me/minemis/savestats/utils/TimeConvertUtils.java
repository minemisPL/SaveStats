package me.minemis.savestats.utils;

import java.util.concurrent.TimeUnit;

public class TimeConvertUtils {

    private TimeConvertUtils() {}

    public static String millisToTime(long time){
        long sek = TimeUnit.MILLISECONDS.toSeconds(time) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(time));
        return String.format("%02d min, %02d sec", TimeUnit.MILLISECONDS.toMinutes(time), sek);
    }

}
