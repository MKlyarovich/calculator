package com.company.app.service.helpers.impl;

import com.company.app.service.helpers.MonthDayResolver;
import org.springframework.stereotype.Component;

@Component
public class FebruaryDaysResolver implements MonthDayResolver {

    @Override
    public boolean isSupport(int monthNumber) {
        return monthNumber == 2;
    }

    @Override
    public int getDaysNumber(boolean isLeapYear) {
        return isLeapYear ? 29 : 28;
    }
}