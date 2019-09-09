package com.company.app.service.helpers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.company.app.service.helpers.DaysInYearsCash.isLeapYear;

/**
 * Class, used for calculating days between dates.
 */
@Component
@RequiredArgsConstructor
public class DateCalculations {

    private final DaysInYearsCash daysInYearsCash;

    /**
     * Method, that calculates days between next month and end of the year.
     *
     * @param month month after which the counting of days begins
     * @param year  year to the end of which days are counted
     * @return counted the number of days
     */
    public int getAmountDaysFromNextMonthToEndYear(int month, int year) {
        int result = 0;

        for (int i = month + 1; i <= 12; i++) {
            result += amountDaysOfMonth(i, year);
        }

        return result;
    }

    /**
     * Method, that calculates days between the beginning of a year and before a month.
     *
     * @param month month before which days are counted
     * @param year  year from the beginning of which days are counted
     * @return counted the number of days
     */
    public int getAmountDaysFromYearBeforeMonth(int month, int year) {
        int result = 0;

        for (int i = 1; i < month; i++) {
            result += amountDaysOfMonth(i, year);
        }

        return result;
    }

    /**
     * Method, that calculates days between next first month and before a second month.
     *
     * @param firstMonth  month after which the counting of days begins
     * @param secondMonth month before which days are counted
     * @param year        year in which days are counted (for LeapYear)
     * @return counted the number of days
     */
    public int getAmountDaysFromNextMonthBeforeMonth(int firstMonth, int secondMonth, int year) {
        int result = 0;

        for (int i = firstMonth + 1; i < secondMonth; i++) {
            result += amountDaysOfMonth(i, year);
        }

        return result;
    }

    /**
     * Method, that calculates days between current day and end of the month.
     *
     * @param day   day after which the counting of days begins
     * @param month month to the end of which days are counted
     * @param year  year in which days are counted (for LeapYear)
     * @return counted the number of days
     */
    public int getAmountDaysFromCurrentDayToEndMonth(int day, int month, int year) {
        return amountDaysOfMonth(month, year) - day;
    }

    /**
     * Method, that calculates days between next first year and before a second year.
     *
     * @param firstYear  year after which the counting of days begins
     * @param secondYear year before which days are counted
     * @return counted the number of days
     */
    public int getAmountDaysFromNextYearBeforeYear(int firstYear, int secondYear) {
        int result = 0;
        Map<Integer, Integer> daysInYearsMap = daysInYearsCash.createMapOfDaysInYears();

        for (int i = firstYear + 1; i < secondYear; i++) {
            result += daysInYearsMap.get(i);
        }

        return result;
    }

    /**
     * Method, that returns the number of days of the month.
     *
     * @param month month that returns the number of days
     * @param year  year in which returns amount days of a month (for LeapYear)
     * @return amount days of the month
     */
    private int amountDaysOfMonth(int month, int year) {
        int result = 0;
        switch (month) {
            case 1:
                result = 31;
                break;
            case 2:
                result = isLeapYear(year) ? 29 : 28;
                break;
            case 3:
                result = 31;
                break;
            case 4:
                result = 30;
                break;
            case 5:
                result = 31;
                break;
            case 6:
                result = 30;
                break;
            case 7:
                result = 31;
                break;
            case 8:
                result = 31;
                break;
            case 9:
                result = 30;
                break;
            case 10:
                result = 31;
                break;
            case 11:
                result = 30;
                break;
            case 12:
                result = 31;
                break;
            default:
                throw new IllegalArgumentException("The month is incorrect. It must be between 1 and 12");
        }

        return result;
    }
}