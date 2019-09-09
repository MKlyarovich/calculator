package com.company.app.service.helpers.impl;

import com.company.app.service.helpers.MonthDayResolver;
import org.springframework.stereotype.Component;

@Component
public class OctoberDaysResolver implements MonthDayResolver {

    @Override
    public boolean isSupport(int monthNumber) {
        return monthNumber == 10;
    }

    @Override
    public int getDaysNumber(boolean isLeapYear) {
        return 31;
    }
}