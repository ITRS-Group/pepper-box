package com.gslab.pepper.test;

import com.gslab.pepper.input.CustomFunctions;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;

public class CustomFunctionsTest {

    @Test
    public void verifyTimeFunctions() {
        assertNotSame(CustomFunctions.NOWUNIQUE(), CustomFunctions.NOWUNIQUE());
    }

}
