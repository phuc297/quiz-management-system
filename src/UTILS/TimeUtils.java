package UTILS;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {

    public static Date stringToDateTime() {
        try {
            String dateString = "2023-04-24 10:30:00";
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            return format.parse(dateString);
        } catch (Exception e) {
        }
        return null;
    }

    public static String durationToString(Duration duration) {
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.toSeconds() % 60;

        String formattedDuration = String.format("%02d:%02d:%02d", hours, minutes, seconds);

        return formattedDuration;
    }

    public static String getNow() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String start = (dtf.format(now)).toString();
        return start;
    }
}
