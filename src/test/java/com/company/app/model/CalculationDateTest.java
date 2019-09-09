package com.company.app.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculationDateTest {

    @Test
    public void compareToTest() {
        CalculationDate firstCalculationDate = new CalculationDate(9, 9, 2019);
        CalculationDate secondCalculationDate = new CalculationDate(9, 1, 2019);

        assertEquals(1, firstCalculationDate.compareTo(secondCalculationDate));

        firstCalculationDate = new CalculationDate(9, 1, 2019);
        secondCalculationDate = new CalculationDate(9, 9, 2019);

        assertEquals(-1, firstCalculationDate.compareTo(secondCalculationDate));

        firstCalculationDate = new CalculationDate(9, 9, 2019);
        secondCalculationDate = new CalculationDate(9, 9, 2019);

        assertEquals(0, firstCalculationDate.compareTo(secondCalculationDate));
    }
}