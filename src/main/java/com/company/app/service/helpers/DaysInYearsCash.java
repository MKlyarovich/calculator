package com.company.app.service.helpers;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DaysInYearsCash {

    private static final int MIN_YEAR = 1900;
    private static final int MAX_YEAR = 2010;
    private static final int AMOUNT_DAYS_IN_NORMAL_YEAR = 365;
    private static final int AMOUNT_DAYS_IN_LEAP_YEAR = 366;

    @PostConstruct
    public void init() {
        createMapOfDaysInYears();
    }

    /**
     * Method, that creates a Map<Integer, Integer> with the <i>years<i/> and <i>number<i/> of days in years.
     *
     * @return map of days and years
     */
    @Cacheable("daysInYears")
    public Map<Integer, Integer> createMapOfDaysInYears() {
        int diffBetweenMaxAndMinYears = MAX_YEAR - MIN_YEAR;

        return Stream.iterate(MIN_YEAR, i -> i + 1)
                .limit(diffBetweenMaxAndMinYears)
                .collect(Collectors.toMap(k -> k, DaysInYearsCash::getAmountDaysInYear));
    }

    static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    private static int getAmountDaysInYear(int year) {
        return isLeapYear(year) ? AMOUNT_DAYS_IN_LEAP_YEAR : AMOUNT_DAYS_IN_NORMAL_YEAR;
    }
}