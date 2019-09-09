package com.company.app.service.helpers;

public interface MonthDayResolver {

    boolean isSupport(int monthNumber);

    int getDaysNumber(boolean isLeapYear);
}