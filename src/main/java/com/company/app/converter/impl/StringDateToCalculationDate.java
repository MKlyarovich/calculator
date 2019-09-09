package com.company.app.converter.impl;

import com.company.app.converter.Converter;
import com.company.app.model.CalculationDate;
import org.springframework.stereotype.Component;

import java.util.StringTokenizer;

@Component
public class StringDateToCalculationDate implements Converter {

    /**
     * Method, which converts String date to CalculationDate.
     *
     * @param source date in string format
     * @return CalculationDate object
     */
    @Override
    public CalculationDate convert(String source) {
        StringTokenizer tokens = new StringTokenizer(source, " ");
        int month = Integer.parseInt(tokens.nextToken());
        int day = Integer.parseInt(tokens.nextToken());
        int year = Integer.parseInt(tokens.nextToken());

        return new CalculationDate(month, day, year);
    }
}