package pl.glozaaleksandra.time;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeProvider {
    public static Instant now() {
        return TimeProvider.fromString(DateTimeFormatter.ISO_INSTANT.format(Instant
                .now()
                .atZone(ZoneId.of("UTC"))
                .truncatedTo(ChronoUnit.SECONDS)));
    }

    public static Instant fromString(String dateTime) {
        try {
            if (dateTime.contains(" ")) {
                dateTime = dateTime.replace(" ", "T");
            }
            return Instant.parse(dateTime);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}

