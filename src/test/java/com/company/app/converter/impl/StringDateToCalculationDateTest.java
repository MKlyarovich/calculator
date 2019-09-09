package com.company.app.converter.impl;

import com.company.app.converter.Converter;
import com.company.app.model.CalculationDate;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StringDateToCalculationDateTest {

    private Converter converter = new StringDateToCalculationDate();

    @Test
    public void convertTest() {
        CalculationDate calculationDate = converter.convert("09 01 2019");
        assertTrue("CalculationDate is null", Objects.nonNull(calculationDate));
        assertEquals("Incorrect month", 9, calculationDate.getMonth());
        assertEquals("Incorrect day", 1, calculationDate.getDay());
        assertEquals("Incorrect year", 2019, calculationDate.getYear());
    }
}