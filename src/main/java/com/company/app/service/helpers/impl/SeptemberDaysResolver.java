package com.company.app.service.helpers.impl;

import com.company.app.service.helpers.MonthDayResolver;
import org.springframework.stereotype.Component;

@Component
public class SeptemberDaysResolver implements MonthDayResolver {

    @Override
    public boolean isSupport(int monthNumber) {
        return monthNumber == 9;
    }

    @Override
    public int getDaysNumber(boolean isLeapYear) {
        return 30;
    }
}