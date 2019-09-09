package com.company.app.service.helpers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DateCalculationsTest {

    @Autowired
    private DateCalculations dateCalculations;

    @Test
    public void getAmountDaysFromNextMonthToEndYearTest() {
        int amountDaysFromYearBeforeMonth = dateCalculations.getAmountDaysFromNextMonthToEndYear(1, 2001);
        assertEquals(334, amountDaysFromYearBeforeMonth);

        amountDaysFromYearBeforeMonth = dateCalculations.getAmountDaysFromNextMonthToEndYear(2, 2000);
        assertEquals(306, amountDaysFromYearBeforeMonth);

        amountDaysFromYearBeforeMonth = dateCalculations.getAmountDaysFromNextMonthToEndYear(5, 2009);
        assertEquals(214, amountDaysFromYearBeforeMonth);

        amountDaysFromYearBeforeMonth = dateCalculations.getAmountDaysFromNextMonthToEndYear(12, 1999);
        assertEquals(0, amountDaysFromYearBeforeMonth);
    }

    @Test
    public void getAmountDaysFromYearBeforeMonthTest() {
        int amountDaysFromYearBeforeMonth = dateCalculations.getAmountDaysFromYearBeforeMonth(1, 2005);
        assertEquals(0, amountDaysFromYearBeforeMonth);

        amountDaysFromYearBeforeMonth = dateCalculations.getAmountDaysFromYearBeforeMonth(3, 2008);
        assertEquals(60, amountDaysFromYearBeforeMonth);

        amountDaysFromYearBeforeMonth = dateCalculations.getAmountDaysFromYearBeforeMonth(12, 1995);
        assertEquals(334, amountDaysFromYearBeforeMonth);
    }

    @Test
    public void getAmountDaysFromNextMonthBeforeMonthTest() {
        int amountDaysFromNextMonthBeforeMonth = dateCalculations.getAmountDaysFromNextMonthBeforeMonth(1, 1, 1997);
        assertEquals(0, amountDaysFromNextMonthBeforeMonth);

        amountDaysFromNextMonthBeforeMonth = dateCalculations.getAmountDaysFromNextMonthBeforeMonth(4, 5, 1996);
        assertEquals(0, amountDaysFromNextMonthBeforeMonth);

        amountDaysFromNextMonthBeforeMonth = dateCalculations.getAmountDaysFromNextMonthBeforeMonth(9, 12, 1993);
        assertEquals(61, amountDaysFromNextMonthBeforeMonth);
    }

    @Test
    public void getAmountDaysFromCurrentDayToEndMonthTest() {
        int amountDaysFromCurrentDayToEndMonth = dateCalculations.getAmountDaysFromCurrentDayToEndMonth(1, 1, 2001);
        assertEquals(30, amountDaysFromCurrentDayToEndMonth);

        amountDaysFromCurrentDayToEndMonth = dateCalculations.getAmountDaysFromCurrentDayToEndMonth(27, 2, 1996);
        assertEquals(2, amountDaysFromCurrentDayToEndMonth);

        amountDaysFromCurrentDayToEndMonth = dateCalculations.getAmountDaysFromCurrentDayToEndMonth(26, 7, 1986);
        assertEquals(5, amountDaysFromCurrentDayToEndMonth);
    }

    @Test
    public void getAmountDaysFromNextYearBeforeYearTest() {
        int amountDaysFromNextYearBeforeYear = dateCalculations.getAmountDaysFromNextYearBeforeYear(1900, 2010);
        assertEquals(39812, amountDaysFromNextYearBeforeYear);

        amountDaysFromNextYearBeforeYear = dateCalculations.getAmountDaysFromNextYearBeforeYear(1960, 1960);
        assertEquals(0, amountDaysFromNextYearBeforeYear);

        amountDaysFromNextYearBeforeYear = dateCalculations.getAmountDaysFromNextYearBeforeYear(1933, 1977);
        assertEquals(15706, amountDaysFromNextYearBeforeYear);
    }
}