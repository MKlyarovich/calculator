package com.company.app.service.helpers;

import org.junit.Test;

import static com.company.app.service.helpers.DaysInYearsCash.isLeapYear;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DateUtilsTest {

    @Test
    public void leapYearTest() {
        assertFalse("1999 is not leap year", isLeapYear(1999));
        assertTrue("2000 is leap year", isLeapYear(2000));
    }
}