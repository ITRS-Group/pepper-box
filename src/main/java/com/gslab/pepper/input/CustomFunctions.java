package com.gslab.pepper.input;

import org.joda.time.DateTime;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The CustomFunctions allows users to write custom functions and then it can be used in template.
 *
 * @Author Satish Bhor<satish.bhor@gslab.com>, Nachiket Kate <nachiket.kate@gslab.com>
 * @Version 1.0
 * @since 01/03/2017
 */
public class CustomFunctions {

    private static final Logger log = Logger.getLogger(FieldDataFunctions.class.getName());

    public static long THREADID() {
        try {
          return Thread.currentThread().getId();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to get thread id", e);
            throw new RuntimeException();

        }
    }

}
