package com.company.app.service.impl;

import com.company.app.converter.Converter;
import com.company.app.model.CalculationDate;
import com.company.app.service.CalculationService;
import com.company.app.service.helpers.DateCalculations;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CalculationServiceImpl implements CalculationService {

    private Converter converter;
    private DateCalculations dateCalculations;

    /**
     * Method, which calculates the difference between two dates.
     *
     * @param firstDate  first date
     * @param secondDate second date
     * @return string in format DD MM YYYY, DD MM YYYY, difference
     */
    @Override
    public String getDifferenceBetweenDates(String firstDate, String secondDate) {
        validateDates(firstDate, secondDate);
        CalculationDate earliestDate;
        CalculationDate latestDate;
        StringBuilder result = new StringBuilder();

        CalculationDate firstCalculationDate = converter.convert(firstDate);
        CalculationDate secondCalculationDate = converter.convert(secondDate);

        if (firstCalculationDate.compareTo(secondCalculationDate) <= 0) {
            earliestDate = firstCalculationDate;
            latestDate = secondCalculationDate;
        } else {
            earliestDate = secondCalculationDate;
            latestDate = firstCalculationDate;
        }

        int difference = calculateDifference(earliestDate, latestDate);

        return result.append(earliestDate)
                .append(", ")
                .append(latestDate)
                .append(", ")
                .append(difference)
                .toString();
    }

    /**
     * Method, which calculates the difference between two dates from the file.
     * File must have only two lines of dates in format DD MM YYYY
     *
     * @param multipartFile file with two dates
     * @return string in format DD MM YYYY, DD MM YYYY, difference
     */
    @Override
    public String getDifferenceBetweenDates(MultipartFile multipartFile) throws IOException {
        List<String> collect = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()))
                .lines()
                .collect(Collectors.toList());

        if (Objects.isNull(collect) || collect.isEmpty() || collect.size() != 2) {
            throw new IllegalArgumentException("The download file must have two date strings in the format MM DD YYYY.");
        }

        return getDifferenceBetweenDates(collect.get(0), collect.get(1));
    }

    /**
     * Method, which calculates the difference between two CalculationDate objects.
     *
     * @param earliestDate date is the earliest
     * @param latestDate   date is the latest
     * @return counted the number of days
     */
    private int calculateDifference(CalculationDate earliestDate, CalculationDate latestDate) {
        int result;

        if (earliestDate.getYear() == latestDate.getYear()) {
            if (earliestDate.getMonth() == latestDate.getMonth()) {
                result = latestDate.getDay() - earliestDate.getDay();
            } else {
                result = dateCalculations.getAmountDaysFromNextMonthBeforeMonth(earliestDate.getMonth(), latestDate.getMonth(), earliestDate.getDay()) +
                        dateCalculations.getAmountDaysFromCurrentDayToEndMonth(earliestDate.getDay(), latestDate.getMonth(), earliestDate.getYear()) +
                        latestDate.getDay();
            }
        } else {
            result = dateCalculations.getAmountDaysFromNextYearBeforeYear(earliestDate.getYear(), latestDate.getYear()) +
                    dateCalculations.getAmountDaysFromNextMonthToEndYear(earliestDate.getMonth(), earliestDate.getYear()) +
                    dateCalculations.getAmountDaysFromYearBeforeMonth(latestDate.getMonth(), latestDate.getYear()) +
                    dateCalculations.getAmountDaysFromCurrentDayToEndMonth(earliestDate.getDay(), latestDate.getMonth(), earliestDate.getYear()) +
                    latestDate.getDay();
        }

        return result;
    }

    public static boolean checkFormatDate(String userNameString) {
        Pattern p = Pattern.compile("(0[1-9]|1\\d|2\\d|3[01])[ ](0[1-9]|1[0-2])[ ](19\\d{2}|200\\d|2010)");
        Matcher m = p.matcher(userNameString);

        return m.matches();
    }

    private void validateDates(String... date) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.asList(date).forEach(d -> {
            if (!checkFormatDate(d)) {
                stringBuilder.append(String.format("%s must match the format DD MM YYYY, the year must be between 1900 and 2010 ", d));
            }
        });

        if (stringBuilder.length() != 0) {
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}