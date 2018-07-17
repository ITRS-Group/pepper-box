package com.gslab.pepper.input;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The CustomFunctions allows users to write custom functions and then it can be used in template.
 *
 * @Author Tobias Johansson<tjohansson@itrsgroup.com>>
 * @Version 1.0
 * @since 17/07/2018
 */
public class CustomFunctions {

    private static final Logger log = Logger.getLogger(FieldDataFunctions.class.getName());
    private static final AtomicLong microseconds = new AtomicLong(0);
    private static final DateTimeFormatter hubDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public static long THREADID() {
        try {
            return Thread.currentThread().getId();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to get thread id", e);
            throw new RuntimeException();

        }
    }

    public static String NOWUNIQUE() {
        long micro = NEXTMICRO();
        return LocalDateTime.now(ZoneOffset.UTC).format(hubDateFormatter) + "." + String.format("%06d", micro) + "Z";
    }

    public static long NEXTMICRO() {
        long count;
        do {
            count = microseconds.get();
            if (count == 1000000) {
                microseconds.set(0);
            }
        } while (!microseconds.compareAndSet(count, count + 1));
        return count;
    }
}
